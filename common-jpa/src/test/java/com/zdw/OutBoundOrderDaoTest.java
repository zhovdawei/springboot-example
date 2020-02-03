package com.zdw;

import com.zdw.dao.OutBoundOrderDao;
import com.zdw.dto.OutBoundOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
@SpringBootTest
public class OutBoundOrderDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private OutBoundOrderDao outBoundOrderDao;

    @Test
    public void insertTest(){
        OutBoundOrder obd = new OutBoundOrder();
        obd.setOrderId(23423846238234532L);
        obd.setOutId(345724444444L);
        obd.setCreateTime(LocalDateTime.now());
        OutBoundOrder obj = outBoundOrderDao.save(obd);
        assertEquals(obj.getOutId(),Long.valueOf(345724444444L));
    }

    @Test
    public void deleteTest(){
        int index = outBoundOrderDao.deleteByOrderId(23423846238234532L);
        assertEquals(index,1);
    }


}
