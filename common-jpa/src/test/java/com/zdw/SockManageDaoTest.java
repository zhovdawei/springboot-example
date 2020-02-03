package com.zdw;

import com.zdw.dao.SockManageDao;
import com.zdw.dto.SockManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class SockManageDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private SockManageDao sockManageDao;

    @Test
    public void insertSockManageTest(){
        SockManage sockManage = new SockManage();
        sockManage.setProductId(2314823428352L);
        sockManage.setTotal(5);
        sockManage.setStatus(1);
        sockManage.setCreateTime(LocalDateTime.now());
        sockManage.setUpdateTime(sockManage.getCreateTime());
        SockManage obj = sockManageDao.save(sockManage);
        assertEquals(obj.getProductId(),Long.valueOf(2314823428352L));
    }

    @Test
    public void updateByProductIdTest(){
        int index = sockManageDao.updateStatusByProductId(2314823428352L,0,LocalDateTime.now());
        assertEquals(index,1);
    }

    @Test
    public void selectByProductIdTest(){
        SockManage sockManage = sockManageDao.findByProductId(2314823428352L);
        assertEquals(sockManage.getStatus(),Integer.valueOf(0));
    }

    @Test
    public void deleteByProductId(){
        int index = sockManageDao.deleteByProductId(2314823428352L);
        assertEquals(index,1);
    }


}
