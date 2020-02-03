package com.zdw;

import com.zdw.dao.OrderDetailDao;
import com.zdw.dto.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class OrderDetailDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Test
    public void orderDetailInsertTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(1231234435341L);
        orderDetail.setProductId(345782634256345L);
        orderDetail.setTotal(5);
        orderDetail.setCreateTime(LocalDateTime.now());
        OrderDetail entity = orderDetailDao.save(orderDetail);
        assertEquals(entity.getOrderId(),Long.valueOf(1231234435341L));
    }

    @Test
    public void insert2Test(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(1231234435341L);
        orderDetail.setProductId(345782634256346L);
        orderDetail.setTotal(7);
        orderDetail.setCreateTime(LocalDateTime.now());
        OrderDetail entity = orderDetailDao.save(orderDetail);
        assertEquals(entity.getOrderId(),Long.valueOf(1231234435341L));
    }

    @Test
    public void findByOrderIdAndProductIdTest(){
        OrderDetail orderDetail = orderDetailDao.findByOrderIdAndProductId(1231234435341L,345782634256346L);
        assertEquals(orderDetail.getTotal(),Integer.valueOf(7));
    }

    @Test
    public void selectByOrderIdTest(){
        List<OrderDetail> orderDetails = orderDetailDao.findByOrderId(1231234435341L);
        assertEquals(orderDetails.size(),2);
    }

    @Test
    public void deleteByOrderIdTest(){
        int index = orderDetailDao.deleteByOrderId(1231234435341L);
        assertEquals(index>=1,true);
    }


}
