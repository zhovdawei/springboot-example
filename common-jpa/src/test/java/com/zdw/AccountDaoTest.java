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
public class AccountDaoTest extends AbstractTestNGSpringContextTests {

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
        System.out.println("新增对象 : "+accountEntity);
        assertEquals(accountEntity.getVipNo(),account.getVipNo());
    }

    @Test
    public void updateBalanceByVipNoTest(){
        Account entity = accountDao.findByVipNo(2360032989544451L);
        entity.setBalance(new BigDecimal(100));
        entity.setUpdateTime(LocalDateTime.now());
        entity = accountDao.saveAndFlush(entity);
        System.out.println(entity);
        assertEquals(entity.getBalance(),new BigDecimal(100));
    }

    @Test
    public void accountSelectByVipNoTest(){
        Account entity = accountDao.findByVipNo(2360032989544451L);
        System.out.println(entity);
        assertEquals(entity.getVipNo(),Long.valueOf(2360032989544451L));
    }

    @Test
    public void accountDeleteByVipNoTest(){
        int flag = accountDao.deleteByVipNo(2360032989544451L);
        assertEquals(flag,1);
    }

    @Test
    public void accountDeleteValidateTest(){
        Account account = accountDao.findByVipNo(2360032989544451L);
        assertEquals(null,account);
    }







}
