package com.zdw.controller;

import com.zdw.dao.UserMapper;
import com.zdw.db.User;
import com.zdw.service.UidGenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UidController {
    @Autowired
    private UidGenService uidGenService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/uidGenerator")
    public String UidGenerator() {
        Long uuid = uidGenService.getUid();
        System.out.println(uuid);
        return String.valueOf(uuid);
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long id){
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }


    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
    }
}
