package com.zdw.dao;

import com.zdw.dto.VipOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

/**
*
* @author MBG
* @created Create Time: Thu Feb 06 14:27:36 CST 2020
*/
@Repository
public interface VipOrderDao extends JpaRepository<VipOrder, Long> {

    @Transactional
    @Modifying
    @Query("update VipOrder set status = ?2,updateTime = ?3 where orderId = ?1")
    int updateByOrderId(long orderId, int status, LocalDateTime dateTime);

    VipOrder findByOrderId(long orderId);

    @Transactional
    int deleteByOrderId(long orderId);

}