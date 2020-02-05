package com.zdw;

import com.zdw.dao.StockManageDao;
import com.zdw.dto.StockManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class SockManageDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private StockManageDao stockManageDao;

    @Test
    public void insertSockManageTest(){
        StockManage stockManage = new StockManage();
        stockManage.setProductId(2314823428352L);
        stockManage.setTotal(5);
        stockManage.setStatus(1);
        stockManage.setCreateTime(LocalDateTime.now());
        stockManage.setUpdateTime(stockManage.getCreateTime());
        StockManage obj = stockManageDao.save(stockManage);
        assertEquals(obj.getProductId(),Long.valueOf(2314823428352L));
    }

    @Test
    public void updateByProductIdTest(){
        int index = stockManageDao.updateStatusByProductId(2314823428352L,0,LocalDateTime.now());
        assertEquals(index,1);
    }

    @Test
    public void selectByProductIdTest(){
        StockManage stockManage = stockManageDao.findByProductId(2314823428352L);
        assertEquals(stockManage.getStatus(),Integer.valueOf(0));
    }

    @Test
    public void deleteByProductId(){
        int index = stockManageDao.deleteByProductId(2314823428352L);
        assertEquals(index,1);
    }


}
