package com.zdw.dao;

import com.zdw.dto.StockManage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

/**
*
* @author MBG
* @created Create Time: Sun Feb 02 03:31:08 CST 2020
*/
@Repository
public interface StockManageDao extends JpaRepository<StockManage, Long> {

    @Transactional
    @Modifying
    @Query("update StockManage set status = ?2 ,updateTime = ?3 where productId =?1")
    int updateStatusByProductId(long productId, int status, LocalDateTime time);

    @Transactional
    int deleteByProductId(long productId);

    StockManage findByProductId(long productId);


}