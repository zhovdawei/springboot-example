package com.zdw;


import com.zdw.dao.ProductDao;
import com.zdw.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class ProductDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private ProductDao productDao;

    @Test
    public void insertProTest(){
        Product product = new Product();
        product.setProductId(234234535353L);
        product.setName("牙膏");
        product.setPrice(new BigDecimal(34.50));
        product.setType(1);
        product.setCreateTime(LocalDateTime.now());
        Product pro = productDao.save(product);
        assertEquals(pro.getProductId(),Long.valueOf(234234535353L));
    }

    @Test
    public void updatePriceTest(){
        int index = productDao.updatePrice(234234535353L,new BigDecimal(45.50));
        assertEquals(index,1);
    }

    @Test
    public void selectByProductIdTest(){
        Product product = productDao.findByProductId(234234535353L);
        assertEquals(product.getPrice(),new BigDecimal(45.5000));
    }

    @Test
    public void deleteByProductIdTest(){
        int index = productDao.deleteByProductId(234234535353L);
        assertEquals(index,1);
    }

}
