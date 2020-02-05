package com.zdw;

import com.zdw.dao.AccountDao;
import com.zdw.dao.UserDao;
import com.zdw.dto.Account;
import com.zdw.dto.User;
import com.zdw.test.generator.EmailGenerator;
import com.zdw.test.generator.IdNoGenerator;
import com.zdw.test.generator.NameGenerator;
import com.zdw.test.generator.PhoneGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class UserAccountRunnable implements Runnable {

    @Autowired
    private UserDao userDao;

    @Autowired
    private AccountDao accountDao;

    @Resource(name = "cachedUidGenerator")
    private UidGenerator uidGenerator;

    @Override
    public void run() {
        createData();
    }

    @Transactional
    public void createData(){
        long vipNo = uidGenerator.getUID();
        try {
            //生成虚拟账户
            Account account = new Account();
            account.setVipNo(vipNo);
            account.setBalance(BigDecimal.valueOf(1000));
            account.setIntegral(0);
            account.setGrade(0);
            account.setCreateTime(LocalDateTime.now());
            account.setUpdateTime(account.getCreateTime());
            accountDao.save(account);
        }catch (Exception e){
            return;
        }

        boolean flag = false;


/*        try {
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
