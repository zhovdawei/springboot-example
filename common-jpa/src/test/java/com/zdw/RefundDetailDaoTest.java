package com.zdw;

import com.zdw.dao.RefundDetailDao;
import com.zdw.dto.RefundDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class RefundDetailDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private RefundDetailDao refundDetailDao;

    @Test
    public void insertOneTest(){
        RefundDetail entity = new RefundDetail();
        entity.setOrderId(111111111111111L);
        entity.setVipNo(2342783452L);
        entity.setSerialNumber(234872384286L);
        entity.setMoney(new BigDecimal(45.98));
        entity.setRefundType(0);
        entity.setRefundWay(1);
        entity.setCreateTime(LocalDateTime.now());
        RefundDetail rd = refundDetailDao.save(entity);
        assertEquals(rd.getSerialNumber(),Long.valueOf(234872384286L));
    }

    @Test
    public void insertMoreTest(){
        List<RefundDetail> list = new ArrayList<>();


        RefundDetail entity = new RefundDetail();
        entity.setOrderId(22222222222L);
        entity.setVipNo(23234242342L);
        entity.setSerialNumber(22342423455555L);
        entity.setMoney(new BigDecimal(6000));
        entity.setRefundType(1);
        entity.setRefundWay(1);
        entity.setCreateTime(LocalDateTime.now());

        RefundDetail entity1 = new RefundDetail();
        entity1.setOrderId(22222222222L);
        entity1.setVipNo(23234242342L);
        entity1.setSerialNumber(22342423455555L);
        entity1.setMoney(new BigDecimal(6000));
        entity1.setRefundType(1);
        entity1.setRefundWay(3);
        entity1.setCreateTime(LocalDateTime.now());

        list.add(entity);
        list.add(entity1);

        List<RefundDetail> rds = refundDetailDao.saveAll(list);
        assertEquals(rds.size(),2);
    }

    @Test
    public void selectByOrderIdTest(){
        List<RefundDetail> list = refundDetailDao.findByOrderId(22222222222L);
        assertEquals(list.size(),2);
    }

    @Test
    public void deleteByOrderIdTest(){
        int index = refundDetailDao.deleteByOrderId(22222222222L);
        assertEquals(index,2);

        int index2 = refundDetailDao.deleteByOrderId(111111111111111L);
        assertEquals(index2,1);
    }

}
