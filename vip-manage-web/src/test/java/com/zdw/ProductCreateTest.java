package com.zdw;

import com.zdw.dao.ProductDao;
import com.zdw.dao.StockManageDao;
import com.zdw.dto.Product;
import com.zdw.dto.StockManage;
import com.zdw.test.generator.ProductGenerator;
import com.zdw.test.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootTest
public class ProductCreateTest extends AbstractTestNGSpringContextTests {

    @Resource(name = "cachedUidGenerator")
    private UidGenerator uidGenerator;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private StockManageDao stockManageDao;

    /**
     * 1-电子,2-水果,3-日用,4-零食,5-酒水,6-化妆品,7-衣服,8-鞋,9-水产
     */


    /**
     * 电子产品生成
     * */
    @Test
    public void dianziProductCreate(){

        for (int i = 0; i < ProductGenerator.ELECTRONIC_TYPE.length; i++) {
            for (int j = 0; j < ProductGenerator.COLOR.length; j++) {
                for (int k = 0; k < ProductGenerator.CUN_CHU.length; k++) {
                    long uid = uidGenerator.getUID();
                    StringBuffer sb = new StringBuffer();
                    sb.append(ProductGenerator.ELECTRONIC_TYPE[i]);
                    sb.append(" ");
                    sb.append(ProductGenerator.COLOR[j]);
                    sb.append(" ");
                    sb.append(ProductGenerator.CUN_CHU[k]);
                    boolean flag = productInsertTest(uid,sb.toString(),1);
                    if(flag){
                        stockInsertTest(uid);
                    }
                }
            }
        }
    }

    /**
     * 水果生成
     * */
    @Test
    public void fruitInsertTest(){
        for (int i = 0; i < ProductGenerator.FRUIT_TYPE.length; i++) {
            for (int j = 0; j < ProductGenerator.WEIGHT.length; j++) {
                long uid = uidGenerator.getUID();
                StringBuffer sb = new StringBuffer();
                sb.append(ProductGenerator.FRUIT_TYPE[i]);
                sb.append(" ");
                sb.append(ProductGenerator.WEIGHT[j]);
                boolean flag = productInsertTest(uid,sb.toString(),1);
                if(flag){
                    stockInsertTest(uid);
                }
            }
        }
    }

    /**
     * 日用品生成
     * */
    @Test
    public void dailyInsertTest(){
        for (int i = 0; i < ProductGenerator.PIN_PAI.length; i++) {
            for (int j = 0; j < ProductGenerator.DAILY_USE_TYPE.length; j++) {
                for (int k = 0; k < ProductGenerator.FEN_SHU.length; k++) {
                    long uid = uidGenerator.getUID();
                    StringBuffer sb = new StringBuffer();
                    sb.append(ProductGenerator.PIN_PAI[i]);
                    sb.append(" ");
                    sb.append(ProductGenerator.DAILY_USE_TYPE[j]);
                    sb.append(" ");
                    sb.append(ProductGenerator.FEN_SHU[k]);
                    boolean flag = productInsertTest(uid,sb.toString(),1);
                    if(flag){
                        stockInsertTest(uid);
                    }
                }
            }
        }
    }

    /**
     * 零食生成
     * */
    @Test
    public void snacksInsertTest(){
        for (int i = 0; i < ProductGenerator.SNACKS_TYPE.length; i++) {
            for (int j = 0; j < ProductGenerator.WEIGHT_KE.length; j++) {
                long uid = uidGenerator.getUID();
                StringBuffer sb = new StringBuffer();
                sb.append(ProductGenerator.SNACKS_TYPE[i]);
                sb.append(" ");
                sb.append(ProductGenerator.WEIGHT_KE[j]);
                boolean flag = productInsertTest(uid,sb.toString(),1);
                if(flag){
                    stockInsertTest(uid);
                }
            }
        }
    }

    /**
     * 酒水生成
     * */
    @Test
    public void drankInsertTest(){
        for (int i = 0; i < ProductGenerator.DRINK_TYPE.length; i++) {
            for (int j = 0; j < ProductGenerator.WEIGHT_ML.length; j++) {
                long uid = uidGenerator.getUID();
                StringBuffer sb = new StringBuffer();
                sb.append(ProductGenerator.DRINK_TYPE[i]);
                sb.append(" ");
                sb.append(ProductGenerator.WEIGHT_ML[j]);
                boolean flag = productInsertTest(uid,sb.toString(),1);
                if(flag){
                    stockInsertTest(uid);
                }
            }
        }
    }

    /**
     * 化妆品生成
     * */
    @Test
    public void cosmeticInsertTest(){
        for (int i = 0; i < ProductGenerator.COSMETIC_TYPE.length; i++) {
            for (int j = 0; j < ProductGenerator.WEIGHT_ML_HUA.length; j++) {
                long uid = uidGenerator.getUID();
                StringBuffer sb = new StringBuffer();
                sb.append(ProductGenerator.COSMETIC_TYPE[i]);
                sb.append(" ");
                sb.append(ProductGenerator.WEIGHT_ML_HUA[j]);
                boolean flag = productInsertTest(uid,sb.toString(),1);
                if(flag){
                    stockInsertTest(uid);
                }
            }
        }
    }


    /**
     * 衣服生成
     * */
    @Test
    public void yifuInsertTest(){
        for (int i = 0; i < ProductGenerator.CLOTHES_TYPE.length; i++) {
            for (int j = 0; j < ProductGenerator.COLOR.length; j++) {
                for (int k = 0; k < ProductGenerator.CHI_MA.length; k++) {
                    long uid = uidGenerator.getUID();
                    StringBuffer sb = new StringBuffer();
                    sb.append(ProductGenerator.CLOTHES_TYPE[i]);
                    sb.append(" ");
                    sb.append(ProductGenerator.COLOR[j]);
                    sb.append(" ");
                    sb.append(ProductGenerator.CHI_MA[k]);
                    boolean flag = productInsertTest(uid,sb.toString(),1);
                    if(flag){
                        stockInsertTest(uid);
                    }
                }
            }
        }
    }


    /**
     * 鞋子生成
     * */
    @Test
    public void shoeInsertTest(){
        for (int i = 0; i < ProductGenerator.SHOE_TYPE.length; i++) {
            for (int j = 0; j < ProductGenerator.COLOR.length; j++) {
                for (int k = 0; k < ProductGenerator.XIE_CHI_MA.length; k++) {
                    long uid = uidGenerator.getUID();
                    StringBuffer sb = new StringBuffer();
                    sb.append(ProductGenerator.SHOE_TYPE[i]);
                    sb.append(" ");
                    sb.append(ProductGenerator.COLOR[j]);
                    sb.append(" ");
                    sb.append(ProductGenerator.XIE_CHI_MA[k]);
                    boolean flag = productInsertTest(uid,sb.toString(),1);
                    if(flag){
                        stockInsertTest(uid);
                    }
                }
            }
        }
    }

    /**
     * 水产生成
     * */
    @Test
    public void shuichangInsertTest(){
        for (int i = 0; i < ProductGenerator.FISHERY_TYPE.length; i++) {
            for (int j = 0; j < ProductGenerator.WEIGHT_FISH.length; j++) {
                long uid = uidGenerator.getUID();
                StringBuffer sb = new StringBuffer();
                sb.append(ProductGenerator.FISHERY_TYPE[i]);
                sb.append(" ");
                sb.append(ProductGenerator.WEIGHT_FISH[j]);
                boolean flag = productInsertTest(uid,sb.toString(),1);
                if(flag){
                    stockInsertTest(uid);
                }
            }
        }
    }


    public boolean productInsertTest(long uid,String name,int type){
        try {
            Product pro = new Product();
            pro.setProductId(uid);
            pro.setName(name);
            pro.setPrice(BigDecimal.valueOf(RandomUtil.getNum(100,1000)));
            pro.setType(type);
            pro.setCreateTime(LocalDateTime.now());
            productDao.save(pro);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public void stockInsertTest(long uid){
        StockManage stock = new StockManage();
        stock.setProductId(uid);
        stock.setStatus(1);
        stock.setTotal(RandomUtil.getNum(10000,100000));
        stock.setCreateTime(LocalDateTime.now());
        stock.setUpdateTime(stock.getCreateTime());
        stockManageDao.save(stock);
    }

    public static void main(String[] args) {
        System.out.println(ProductGenerator.ELECTRONIC_TYPE.length);
        System.out.println(ProductGenerator.COLOR.length);
        System.out.println(ProductGenerator.CUN_CHU.length);
    }

}
