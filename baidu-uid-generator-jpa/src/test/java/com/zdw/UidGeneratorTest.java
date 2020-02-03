package com.zdw;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.annotation.Resource;

@SpringBootTest
public class UidGeneratorTest extends AbstractTestNGSpringContextTests {

    @Resource(name = "cachedUidGenerator")
    private UidGenerator uidGenerator;

    @Test
    public void uidCreateTest(){
        System.out.println(uidGenerator.getUID());
    }

}
