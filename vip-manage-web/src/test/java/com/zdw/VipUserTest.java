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

@SpringBootTest
public class VipUserTest extends AbstractTestNGSpringContextTests {

    @Resource(name = "cachedUidGenerator")
    private UidGenerator uidGenerator;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AccountDao accountDao;

    @Test
    public void accountCreateTest() {
        /*for (int i = 0; i < 1000000; i++) {
            createData();
        }*/
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500000; i++) {
                    createData();
                }
            }
        },"Tread-0").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500000; i++) {
                    createData();
                }
            }
        },"Tread-1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500000; i++) {
                    createData();
                }
            }
        },"Tread-2").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500000; i++) {
                    createData();
                }
            }
        },"Tread-3").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500000; i++) {
                    createData();
                }
            }
        },"Tread-4").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500000; i++) {
                    createData();
                }
            }
        },"Tread-5").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500000; i++) {
                    createData();
                }
            }
        },"Tread-6").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500000; i++) {
                    createData();
                }
            }
        },"Tread-7").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500000; i++) {
                    createData();
                }
            }
        },"Tread-8").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500000; i++) {
                    createData();
                }
            }
        },"Tread-9").start();


        try {
            Thread.sleep(1000*60*60*4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void createData(){
        long vipNo = uidGenerator.getUID();
        try {
            //生成虚拟账户
            Account account = new Account();
            account.setVipNo(vipNo);
            account.setBalance(BigDecimal.valueOf(RandomUtil.getNum(100,1000)));
            account.setIntegral(0);
            account.setGrade(RandomUtil.getNum(0,6));
            account.setCreateTime(LocalDateTime.now());
            account.setUpdateTime(account.getCreateTime());
            accountDao.save(account);
        }catch (Exception e){
            return;
        }

        boolean flag = false;
        int x = 0;
        while (!flag){
            x++;
            if(x<=10){
                flag = insertUser(vipNo);
            }else {
                deleteAccount(vipNo);
            }
        }

        /*try {
            userInsert(vipNo);
        }catch (Exception e){
            try {
                userInsert(vipNo);
            }catch (Exception ex){
                deleteAccount(vipNo);
            }
        }*/

    }

    public void userInsert(long vipNo) throws Exception{
        //生成虚拟用户信息
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
