package com.zdw;

import static org.junit.Assert.assertEquals;

import com.zdw.dao.OutBoundDetailDao;
import com.zdw.dto.OutBoundDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class OutBoundDetailDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private OutBoundDetailDao outBoundDetailDao;

    @Test
    public void insertListTest(){
        List<OutBoundDetail> list = new ArrayList<>();

        OutBoundDetail obj1 = new OutBoundDetail();
        obj1.setOutId(34582429759713L);
        obj1.setProductId(23472354242L);
        obj1.setTotal(6);
        obj1.setCreateTime(LocalDateTime.now());

        OutBoundDetail obj2 = new OutBoundDetail();
        obj2.setOutId(34582429759713L);
        obj2.setProductId(23472354243L);
        obj2.setTotal(7);
        obj2.setCreateTime(LocalDateTime.now());

        OutBoundDetail obj3 = new OutBoundDetail();
        obj3.setOutId(34582429759713L);
        obj3.setProductId(23472354244L);
        obj3.setTotal(11);
        obj3.setCreateTime(LocalDateTime.now());


        list.add(obj1);
        list.add(obj2);
        list.add(obj3);

        List<OutBoundDetail> obds = outBoundDetailDao.saveAll(list);
        assertEquals(obds.size(),3);
        for (OutBoundDetail obd : obds) {
            System.out.println(obd);
        }
    }

    @Test
    public void deleteByOrderId(){
        int index = outBoundDetailDao.deleteByOutId(34582429759713L);
        assertEquals(index,3);
    }

}
