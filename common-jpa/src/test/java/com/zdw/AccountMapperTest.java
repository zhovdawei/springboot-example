package com.zdw;

import com.zdw.dao.AccountDao;
import com.zdw.dto.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class AccountMapperTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private AccountDao accountDao;

    @Test
    public void accountInsertTest(){
        Account account = new Account();
        account.setVipNo(2360032989544451L);
        account.setBalance(new BigDecimal(203000));
        account.setIntegral(103000);
        account.setGrade(4);
        account.setCreateTime(LocalDateTime.now());
        account.setUpdateTime(account.getCreateTime());
        Account accountEntity = accountDao.save(account);
        assertEquals(accountEntity.getVipNo(),account.getVipNo());
    }

    @Test
    public void accountSelectByVipNoTest(){
        Account entity = accountDao.findByVipNo(2360032989544451L);
        System.out.println(entity);
        assertEquals(entity.getVipNo(),Long.valueOf(2360032989544451L));
    }

}
