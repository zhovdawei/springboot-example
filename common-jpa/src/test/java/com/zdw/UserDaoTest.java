package com.zdw;

import com.zdw.dao.UserDao;
import com.zdw.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class UserDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void userInsertTest(){
        User user = new User();
        user.setName("zdw222");
        user.setNickname("慌德·布耀布耀德");
        user.setVipNo(2360032989544458L);
        user.setNumber("429005202002020208");
        user.setPhone("188-8888-4444");
        user.setEmail("zdw0607@gmail.com");
        user.setSex(0);
        user.setBirthday(LocalDate.parse("2000-07-12"));
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(user.getCreateTime());
        User userObj = userDao.save(user);
        assertEquals(userObj.getVipNo(),Long.valueOf(2360032989544458L));
    }

    @Test
    public void updateByIdTest(){
        User user = userDao.findByVipNo(2360032989544458L);
        user.setName("周大伟");
        user.setBirthday(LocalDate.parse("1991-06-07"));
        user = userDao.saveAndFlush(user);
        System.out.println(user);
        assertEquals(user.getName(),"周大伟");
    }

    @Test
    public void updateByVipNoTest(){
        int index = userDao.updateNameByVipNo(2360032989544458L,"zhovdawei");
        assertEquals(index,1);
    }

    @Test
    public void selectByVipNoTest(){
        User user = userDao.findByVipNo(2360032989544458L);
        System.out.println("user -> "+user);
        assertEquals(user.getName(),"zhovdawei");
    }

    @Test
    public void deleteByVipNoTest(){
        int flag = userDao.deleteByVipNo(2360032989544458L);
        assertEquals(1,flag);
    }

    @Test
    public void validateDeleteTest(){
        User user = userDao.findByVipNo(2360032989544458L);
        assertEquals(null,user);
    }
}
