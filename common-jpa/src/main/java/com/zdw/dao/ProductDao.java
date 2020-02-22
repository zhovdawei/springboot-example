package com.zdw.dao;

import com.zdw.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;

/**
*
* @author MBG
* @created Create Time: Sun Feb 02 03:31:08 CST 2020
*/
@Repository
public interface ProductDao extends JpaRepository<Product, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Product SET price = ?2 WHERE productId = ?1")
    int updatePrice(Long productId, BigDecimal price);

    @Transactional
    int deleteByProductId(long productId);

    Product findByProductId(long productId);

    Product findById(long id);



}