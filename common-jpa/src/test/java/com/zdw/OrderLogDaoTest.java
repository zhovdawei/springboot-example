package com.zdw;

import com.zdw.dao.OrderLogDao;
import com.zdw.dto.OrderLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class OrderLogDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private OrderLogDao orderLogDao;

    @Test
    public void insertOneTest(){
        OrderLog orderLog = new OrderLog();
        orderLog.setOrderId(234528429293242L);
        orderLog.setLogInfo("订单号："+orderLog.getOrderId()+",生成未支付订单。");
        orderLog.setHandler("david");
        orderLog.setCreateTime(LocalDateTime.now());
        OrderLog entity = orderLogDao.save(orderLog);
        assertEquals(entity.getOrderId(),Long.valueOf(234528429293242L));
    }

    @Test
    public void insertTwoTest(){
        OrderLog orderLog = new OrderLog();
        orderLog.setOrderId(234528429293242L);
        orderLog.setLogInfo("订单号："+orderLog.getOrderId()+",发起支付操作。");
        orderLog.setHandler("david");
        orderLog.setCreateTime(LocalDateTime.now());
        OrderLog entity = orderLogDao.save(orderLog);
        assertEquals(entity.getOrderId(),Long.valueOf(234528429293242L));
    }

    @Test
    public void insertThreeTest(){
        OrderLog orderLog = new OrderLog();
        orderLog.setOrderId(234528429293242L);
        orderLog.setLogInfo("订单号："+orderLog.getOrderId()+",取消订单。");
        orderLog.setHandler("david");
        orderLog.setCreateTime(LocalDateTime.now());
        OrderLog entity = orderLogDao.save(orderLog);
        assertEquals(entity.getOrderId(),Long.valueOf(234528429293242L));
    }

    @Test
    public void selectByOrderIdTest(){
        List<OrderLog> orderLogs = orderLogDao.findByOrderId(234528429293242L);
        assertEquals(orderLogs.size(),3);
    }

    @Test
    public void deleteByOrderIdTest(){
        int index = orderLogDao.deleteByOrderId(234528429293242L);
        assertEquals(index==3,true);
    }


}
