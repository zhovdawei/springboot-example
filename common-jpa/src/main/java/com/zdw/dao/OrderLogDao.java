package com.zdw.dao;

import com.zdw.dto.OrderLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
*
* @author MBG
* @created Create Time: Sun Feb 02 03:31:08 CST 2020
*/
@Repository
public interface OrderLogDao extends JpaRepository<OrderLog, Long> {

    List<OrderLog> findByOrderId(long orderId);

    @Transactional
    int deleteByOrderId(long orderId);


}