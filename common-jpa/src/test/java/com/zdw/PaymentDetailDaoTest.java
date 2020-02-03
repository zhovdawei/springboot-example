package com.zdw;


import com.zdw.dao.PaymentDetailDao;
import com.zdw.dto.PaymentDetail;
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
public class PaymentDetailDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private PaymentDetailDao paymentDetailDao;


    @Test
    public void testSimplePaymentInsert(){
        PaymentDetail pd = new PaymentDetail();
        pd.setOrderId(234238946289422L);
        pd.setVipNo(345834573789573L);
        pd.setMoney(new BigDecimal(600));
        pd.setPayType(0);
        pd.setPayWay(1);
        pd.setSerialNumber(3485726386283624L);
        pd.setCreateTime(LocalDateTime.now());
        PaymentDetail entity = paymentDetailDao.save(pd);
        assertEquals(entity.getOrderId(),Long.valueOf(234238946289422L));
    }

    @Test
    public void testMixPaymentInsert(){
        List<PaymentDetail> pds = new ArrayList<>();

        PaymentDetail pd1 = new PaymentDetail();
        pd1.setOrderId(111111111111111111L);
        pd1.setVipNo(111111111111111111L);
        pd1.setMoney(new BigDecimal(600));
        pd1.setPayType(1);
        pd1.setPayWay(1);
        pd1.setSerialNumber(111111111111111111L);
        pd1.setCreateTime(LocalDateTime.now());

        PaymentDetail pd2 = new PaymentDetail();
        pd2.setOrderId(111111111111111111L);
        pd2.setVipNo(2222222222222222L);
        pd2.setMoney(new BigDecimal(200));
        pd2.setPayType(1);
        pd2.setPayWay(3);
        pd2.setSerialNumber(2222222222222222L);
        pd2.setCreateTime(LocalDateTime.now());

        pds.add(pd1);
        pds.add(pd2);

        List<PaymentDetail> paymentDetails = paymentDetailDao.saveAll(pds);
        assertEquals(paymentDetails.size(),2);
    }

    @Test
    public void selectByOrderId(){
        List<PaymentDetail> list = paymentDetailDao.findByOrderId(111111111111111111L);
        assertEquals(list.size(),2);
    }


    @Test
    public void deleteByOrderId(){
        //删除单一支付记录
        int index1 = paymentDetailDao.deleteByOrderId(234238946289422L);
        assertEquals(index1,1);

        //删除混合支付
        int index2 = paymentDetailDao.deleteByOrderId(111111111111111111L);
        assertEquals(index2,2);
    }


}
