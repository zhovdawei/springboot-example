package com.zdw.dao;

import com.zdw.dto.OutBoundOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
*
* @author MBG
* @created Create Time: Thu Feb 06 15:01:20 CST 2020
*/
@Repository
public interface OutBoundOrderDao extends JpaRepository<OutBoundOrder, Long> {

    @Transactional
    int deleteByOrderId(long orderId);

}