package com.zdw;

import com.zdw.dao.*;
import com.zdw.dto.*;
import com.zdw.test.generator.IdNoGenerator;
import com.zdw.test.util.RandomUtil;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class OrderTest extends AbstractTestNGSpringContextTests {

    @Resource(name = "cachedUidGenerator")
    private UidGenerator uidGenerator;

    @Autowired
    private VipOrderDao vipOrderDao;

    @Autowired
    private PaymentDetailDao paymentDetailDao;

    @Autowired
    private RefundDetailDao refundDetailDao;

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Autowired
    private OutBoundOrderDao outBoundOrderDao;

    @Autowired
    private OutBoundDetailDao outBoundDetailDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao userDao;

    @Test
    public void allOrderTest(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500000; i++) {
//                    System.out.println("Order-Thread-0 -> "+i+" start------------------------>");
                    orderCommonTest();
                    if((i+1)%10000==0){
                        System.out.println(Thread.currentThread().getName()+" -> "+(i+1));
                    }
//                    System.out.println("Order-Thread-0 -> "+i+" end------------------------>");
                }
            }
        },"Order-Thread-0").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500000; i++) {
//                    System.out.println("Order-Thread-1 -> "+i+" start------------------------>");
                    orderCommonTest();
                    if((i+1)%10000==0){
                        System.out.println(Thread.currentThread().getName()+" -> "+(i+1));
                    }
//                    System.out.println("Order-Thread-1 -> "+i+" end------------------------>");
                }
            }
        },"Order-Thread-1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500000; i++) {
//                    System.out.println("Order-Thread-2 -> "+i+" start------------------------>");
                    orderCommonTest();
                    if((i+1)%10000==0){
                        System.out.println(Thread.currentThread().getName()+" -> "+(i+1));
                    }
//                    System.out.println("Order-Thread-2 -> "+i+" end------------------------>");
                }
            }
        },"Order-Thread-2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500000; i++) {
//                    System.out.println("Order-Thread-3 -> "+i+" start------------------------>");
                    orderCommonTest();
                    if((i+1)%10000==0){
                        System.out.println(Thread.currentThread().getName()+" -> "+(i+1));
                    }
//                    System.out.println("Order-Thread-3 -> "+i+" end------------------------>");
                }
            }
        },"Order-Thread-3").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500000; i++) {
//                    System.out.println("Order-Thread-4 -> "+i+" start------------------------>");
                    orderCommonTest();
                    if((i+1)%10000==0){
                        System.out.println(Thread.currentThread().getName()+" -> "+(i+1));
                    }
//                    System.out.println("Order-Thread-4 -> "+i+" end------------------------>");
                }
            }
        },"Order-Thread-4").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500000; i++) {
//                    System.out.println("Order-Thread-4 -> "+i+" start------------------------>");
                    orderCommonTest();
                    if((i+1)%10000==0){
                        System.out.println(Thread.currentThread().getName()+" -> "+(i+1));
                    }
//                    System.out.println("Order-Thread-4 -> "+i+" end------------------------>");
                }
            }
        },"Order-Thread-5").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500000; i++) {
//                    System.out.println("Order-Thread-4 -> "+i+" start------------------------>");
                    orderCommonTest();
                    if((i+1)%10000==0){
                        System.out.println(Thread.currentThread().getName()+" -> "+(i+1));
                    }
//                    System.out.println("Order-Thread-4 -> "+i+" end------------------------>");
                }
            }
        },"Order-Thread-6").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500000; i++) {
//                    System.out.println("Order-Thread-6 -> "+i+" start------------------------>");
                    orderCommonTest();
                    if((i+1)%10000==0){
                        System.out.println(Thread.currentThread().getName()+" -> "+(i+1));
                    }
//                    System.out.println("Order-Thread-6 -> "+i+" end------------------------>");
                }
            }
        },"Order-Thread-7").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500000; i++) {
//                    System.out.println("Order-Thread-7 -> "+i+" start------------------------>");
                    orderCommonTest();
                    if((i+1)%10000==0){
                        System.out.println(Thread.currentThread().getName()+" -> "+(i+1));
                    }
//                    System.out.println("Order-Thread-7 -> "+i+" end------------------------>");
                }
            }
        },"Order-Thread-8").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500000; i++) {
//                    System.out.println("Order-Thread-8 -> "+i+" start------------------------>");
                    orderCommonTest();
                    if((i+1)%10000==0){
                        System.out.println(Thread.currentThread().getName()+" -> "+(i+1));
                    }
//                    System.out.println("Order-Thread-8 -> "+i+" end------------------------>");
                }
            }
        },"Order-Thread-9").start();

        try {
            Thread.sleep(1000*60*60*7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public void orderCommonTest(){
        //生成一个有效的订单号
        long orderId = uidGenerator.getUID();
        VipOrder vipOrder = vipOrderDao.findByOrderId(orderId);
        while (null!=vipOrder){
            orderId = uidGenerator.getUID();
            vipOrder = vipOrderDao.findByOrderId(orderId);
        }
//        System.out.println(Thread.currentThread().getName()+" -> orderId :"+orderId);
        //插入随机条目的订单详情
        BigDecimal sumMoney = orderDetailInsertTest(orderId);
//        System.out.println(Thread.currentThread().getName()+" -> sumMoney :"+sumMoney.doubleValue());
        if(sumMoney.compareTo(new BigDecimal(0))==0){
            return;
        }

        //随机用户 10078008
        User user = null;
        while (null==user){
            user = userDao.findById(RandomUtils.nextLong(1L,10078008L));
        }

        //生成随机订单状态
//        vipOrderInsertTest(orderId,RandomUtils.nextInt(1,4),sumMoney,user);
//        return true;
        int status = RandomUtils.nextInt(0,9);
        if(status<4){
            vipOrderInsertTest(orderId,4,sumMoney,user);
        }else if(4<=status && status < 9){
            vipOrderInsertTest(orderId,1,sumMoney,user);
            paymentInsertTest(orderId,user.getVipNo(),sumMoney);
        }else {
            vipOrderInsertTest(orderId,3,sumMoney,user);
        }
//        System.out.println(Thread.currentThread().getName()+" -> status :"+status);
    }


    /**
     * 插入订单详情
     * */
    public BigDecimal orderDetailInsertTest(long orderId){
        List<OrderDetail> ods = new ArrayList<>();
        String productId = "";
        BigDecimal moneySum = new BigDecimal(0);
        int rows = RandomUtil.getNum(1,5);
        try {
            for (int i = 0; i < rows; i++) {
                OrderDetail ode = new OrderDetail();
                Product pro = null;
                boolean congfuFlag = true;
                while (congfuFlag){
                    pro = null;
                    while (pro == null){
                        pro = productDao.findById(Long.parseLong(RandomUtil.getNum(1,23001)+""));
                    }
                    congfuFlag = productId.indexOf(String.valueOf(pro.getProductId()))>-1;
                }
                productId = productId + pro.getProductId()+"-";
                ode.setProductId(pro.getProductId());
                ode.setOrderId(orderId);
                ode.setTotal(RandomUtil.getNum(1,3));
                ode.setCreateTime(LocalDateTime.now());
                BigDecimal totalMoney = BigDecimal.valueOf(ode.getTotal()).multiply(pro.getPrice());
                moneySum = moneySum.add(totalMoney);
                ods.add(ode);
//                try {
//                    orderDetailDao.save(ode);
//
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
            }
            orderDetailDao.saveAll(ods);
        }catch (Exception e){
            return new BigDecimal(0);
        }
        return moneySum;
    }

    /**
     * 插入订单
     * */
    public void vipOrderInsertTest(long orderId,int status,BigDecimal sumMoney,User user){
        VipOrder order = new VipOrder();
        order.setOrderId(orderId);

        order.setVipNo(user.getVipNo());
        order.setPaySum(sumMoney);
        order.setStatus(status);
        order.setPickUser(user.getName());
        order.setPickPhone(user.getPhone());
        order.setPickAddress(IdNoGenerator.getRegisteredAddress(user.getNumber()));
        order.setCreateTime(LocalDateTime.now());
        order.setUpdateTime(order.getCreateTime());
        vipOrderDao.save(order);
    }

    /**
     * 插入支付详情
     * */
    public void paymentInsertTest(long orderId,long vipNo,BigDecimal sumMoney){
        boolean saveFlag = false;
        while (!saveFlag){
            try {
                PaymentDetail paymentDetail = new PaymentDetail();
                paymentDetail.setVipNo(vipNo);
                paymentDetail.setOrderId(orderId);
                paymentDetail.setMoney(sumMoney);
                paymentDetail.setPayType(0);
                paymentDetail.setPayWay(RandomUtils.nextInt(1,7));
                paymentDetail.setSerialNumber(uidGenerator.getUID());
                paymentDetail.setCreateTime(LocalDateTime.now());
                paymentDetailDao.save(paymentDetail);
                saveFlag = true;
            }catch (Exception e){
                saveFlag = false;
            }
        }
    }


    /**
     * 插入退款详情
     * */
    public void refundInsertTest(long orderId,long vipNo,BigDecimal sumMoney){
        boolean saveFlag = false;
        while (!saveFlag){
            try {
                RefundDetail refundDetail = new RefundDetail();
                refundDetail.setVipNo(vipNo);
                refundDetail.setOrderId(orderId);
                refundDetail.setMoney(sumMoney);
                refundDetail.setRefundType(0);
                refundDetail.setRefundWay(1);
                refundDetail.setSerialNumber(uidGenerator.getUID());
                refundDetail.setCreateTime(LocalDateTime.now());
                refundDetailDao.save(refundDetail);
                saveFlag = true;
            }catch (Exception e){
                saveFlag = false;
            }
        }
    }



    public boolean vipOrderInsert(long orderId, int status, BigDecimal money){
        return false;
    }


    @Test
    public void test(){
        Product pro = productDao.findById(13304L);
        System.out.println(pro==null);
    }


}
