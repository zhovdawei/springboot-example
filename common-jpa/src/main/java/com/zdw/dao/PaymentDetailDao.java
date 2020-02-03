package com.zdw.dao;

import com.zdw.dto.PaymentDetail;
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
public interface PaymentDetailDao extends JpaRepository<PaymentDetail, Long> {

    @Transactional
    int deleteByOrderId(long orderId);

    List<PaymentDetail> findByOrderId(long orderId);

}