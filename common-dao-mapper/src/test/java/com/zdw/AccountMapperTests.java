package com.zdw;

import com.zdw.dao.AccountMapper;
import com.zdw.dao.UserMapper;
import com.zdw.db.Account;
import com.zdw.db.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
class AccountMapperTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void accountInsertTest(){
        Account account = new Account();
        account.setVipNo(2360032989544451L);
        account.setBalance(new BigDecimal(203000));
        account.setIntegral(103000);
        account.setGrade(4);
        account.setCreateTime(LocalDateTime.now());
        account.setUpdateTime(account.getCreateTime());
        accountMapper.insert(account);
        System.out.println(account.getCreateTime());
    }

}
