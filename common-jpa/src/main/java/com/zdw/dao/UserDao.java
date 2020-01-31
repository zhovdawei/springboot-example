package com.zdw.dao;

import com.zdw.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
*
* @author MBG
* @created Create Time: Fri Jan 31 04:44:48 CST 2020
*/
@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User findByVipNo(long vipNo);

    @Transactional
    int deleteByVipNo(long vipNo);
}