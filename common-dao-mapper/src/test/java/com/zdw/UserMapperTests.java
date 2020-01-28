package com.zdw;

import com.zdw.dao.UserMapper;
import com.zdw.db.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
public class UserMapperTests {

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
        userMapper.insert(user);
        System.out.println(user.getCreateTime());
        System.out.println(user.getUpdateTime());
    }

    @Test
    public void userSelectTest(){
        User user = userMapper.selectByPrimaryKey(7L);
        System.out.println(user);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dtf.format(user.getCreateTime()));
        System.out.println(user.getUpdateTime());
    }

}
