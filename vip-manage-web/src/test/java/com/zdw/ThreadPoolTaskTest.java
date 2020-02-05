package com.zdw;

import com.zdw.dao.AccountDao;
import com.zdw.dao.UserDao;
import com.zdw.dto.Account;
import com.zdw.dto.User;
import com.zdw.test.generator.EmailGenerator;
import com.zdw.test.generator.IdNoGenerator;
import com.zdw.test.generator.NameGenerator;
import com.zdw.test.generator.PhoneGenerator;
import com.zdw.test.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.*;

@SpringBootTest
public class ThreadPoolTaskTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private UserDao userDao;

    @Autowired
    private AccountDao accountDao;

    @Resource(name = "cachedUidGenerator")
    private UidGenerator uidGenerator;

    private BlockingQueue<Long> accountQueue = new LinkedBlockingQueue<>(1024*500);
    private BlockingQueue<Long> userQueue = new LinkedBlockingQueue<>(1024*500);


    @Test
    public void threadPoolTest(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                createUidTest();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                createUidTest();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                createUidTest();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                createUidTest();
            }
        }).start();

        try {
            Thread.sleep(1000*5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                userPoolTest();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                accountPoolTest();
            }
        }).start();


        try {
            Thread.sleep(1000*60*60*4);
        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }


    public void createUidTest(){
        for (int i = 0; i < 1000000; i++) {
            long uid = uidGenerator.getUID();
            boolean userFlag = userQueue.offer(uid);
            if(userFlag){
                boolean accountFlag = false;
                int x = 0;
                while (!accountFlag){
                    x++;
                    if(x<=100){
                        accountFlag = accountQueue.offer(uid);
                    }else {
                        accountFlag = true;
                    }
                }
            }
        }
    }


    public void userPoolTest(){
        BlockingQueue<Runnable> queueUser = new ArrayBlockingQueue<>(1024);
        ThreadPoolExecutor threadPoolUser = new ThreadPoolExecutor(5,10,1000, TimeUnit.MILLISECONDS,queueUser);

        while (null!=userQueue.peek()){
            try {
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            threadPoolUser.execute(new Runnable() {
                @Override
                public void run() {
                    Long uid = userQueue.poll();
                    if(null!=uid){
                        boolean flag = false;
                        int index = 0;
                        while (!flag){
                            index ++;
                            if(index <= 100){
                                flag = insertUser(uid);
                            }else {
                                flag = true;
                                System.out.println("=============================================================");
                                System.out.println("User插入失败...("+uid+")");
                                System.out.println("=============================================================");
                            }
                        }
                    }
                }
            });
        }
    }

    public void accountPoolTest(){
        BlockingQueue<Runnable> queueAccount = new ArrayBlockingQueue<>(1024);
        ThreadPoolExecutor threadPoolAccount = new ThreadPoolExecutor(5,10,1000, TimeUnit.MILLISECONDS,queueAccount);

        while (null!=accountQueue.peek()){
            try {
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            threadPoolAccount.execute(new Runnable() {
                @Override
                public void run() {
                    Long uid = accountQueue.poll();
                    if(null!=uid){
                        boolean flag = false;
                        int index = 0;
                        while (!flag){
                            index ++;
                            if(index <= 100){
                                flag = insertAccount(uid);
                            }else {
                                flag = true;
                                System.out.println("=============================================================");
                                System.out.println("Account插入失败...("+uid+")");
                                System.out.println("=============================================================");
                            }
                        }
                    }
                }
            });
        }
    }



    public boolean insertAccount(long vipNo) {
        //生成虚拟账户
        try {
            Account account = new Account();
            account.setVipNo(vipNo);
            account.setBalance(BigDecimal.valueOf(RandomUtil.getNum(100,1000)));
            account.setIntegral(1000);
            account.setGrade(0);
            account.setCreateTime(LocalDateTime.now());
            account.setUpdateTime(account.getCreateTime());
            accountDao.save(account);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean insertUser(long vipNo) {
        //生成虚拟用户信息
        try {
            User u = new User();
            u.setVipNo(vipNo);
            String idCardNo = IdNoGenerator.generate();
            u.setNumber(idCardNo);
            int sex = IdNoGenerator.getSex(idCardNo);
            u.setSex(sex);
            String birthday = IdNoGenerator.getBirthday(idCardNo);
            u.setBirthday(LocalDate.parse(birthday.substring(0,4)+"-"+birthday.substring(4,6)+"-"+birthday.substring(6,8)));
            String name = NameGenerator.getChineseName(sex);
            u.setName(name);
            u.setEmail(EmailGenerator.getEmail(name));
            u.setPhone(PhoneGenerator.getTel());
            u.setCreateTime(LocalDateTime.now());
            u.setUpdateTime(u.getCreateTime());
            userDao.save(u);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public void deleteAccount(long vipNo){
        accountDao.deleteByVipNo(vipNo);
    }

}
