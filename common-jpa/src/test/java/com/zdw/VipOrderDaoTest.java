package com.zdw;

import com.zdw.dao.VipOrderDao;
import com.zdw.dto.VipOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class VipOrderDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private VipOrderDao vipOrderDao;

    @Test
    public void insertOrderTest(){
        VipOrder order = new VipOrder();
        order.setOrderId(234892359825629L);
        order.setVipNo(3472323984389L);
        order.setPaySum(new BigDecimal(198));
        order.setStatus(0);
        order.setCreateTime(LocalDateTime.now());
        order.setUpdateTime(order.getCreateTime());
        VipOrder vp = vipOrderDao.save(order);
        assertEquals(vp.getOrderId(),Long.valueOf(234892359825629L));
    }

    @Test
    public void updateStatusTest(){
        int index = vipOrderDao.updateByOrderId(234892359825629L,1,LocalDateTime.now());
        assertEquals(index,1);
    }

    @Test
    public void findByOrderIdTest(){
        VipOrder vp = vipOrderDao.findByOrderId(234892359825629L);
        assertEquals(vp.getStatus(),Integer.valueOf(1));
    }

    @Test
    public void deleteOrderTest(){
        int index = vipOrderDao.deleteByOrderId(234892359825629L);
        assertEquals(index,1);
    }


}
