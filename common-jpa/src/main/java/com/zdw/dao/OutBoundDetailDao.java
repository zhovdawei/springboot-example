package com.zdw.dao;

import com.zdw.dto.OutBoundDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
*
* @author MBG
* @created Create Time: Sun Feb 02 03:31:08 CST 2020
*/
@Repository
public interface OutBoundDetailDao extends JpaRepository<OutBoundDetail, Long> {

    @Transactional
    int deleteByOutId(long outId);

}