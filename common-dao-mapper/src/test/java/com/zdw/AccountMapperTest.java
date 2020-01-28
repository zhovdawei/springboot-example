package com.zdw;

import com.zdw.dao.AccountMapper;
import com.zdw.db.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import static org.junit.Assert.assertEquals;

@SpringBootTest
public class AccountMapperTest  extends AbstractTestNGSpringContextTests {

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
        int flag = accountMapper.insert(account);
        System.out.println("11111111111111111");
        assertEquals(flag,1);
    }

}
