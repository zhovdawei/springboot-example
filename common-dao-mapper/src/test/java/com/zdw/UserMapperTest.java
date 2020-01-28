package com.zdw;

import com.zdw.dao.UserMapper;
import com.zdw.db.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class UserMapperTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void userInsertTest(){
        User user = new User();
        user.setName("zdw222");
        user.setNickname("慌德·布耀布耀德");
        user.setVipNo(2360032989544458L);
        user.setNumber("429005202002020208");
        user.setPhone("188-8888-4444");
        user.setEmail("zdw0607@gmail.com");
        user.setSex(false);
        user.setBirthday(LocalDate.parse("2000-07-12"));
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(user.getCreateTime());
        int flag = userMapper.insert(user);

        System.out.println("2222222222222222");
        assertEquals(flag,1);
    }

    @Test
    public void selectByVipNoTest(){

        System.out.println("3333333333333333");
        User user = userMapper.selectByVipNo(2360032989544458L);
        System.out.println("user -> "+user);
        assertEquals(user.getId(),Long.valueOf(2360032989544458L));
    }

}
