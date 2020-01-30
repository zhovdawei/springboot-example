package com.zdw.dao;

import com.zdw.dto.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
*
* @author MBG
* @created Create Time: Fri Jan 31 04:47:59 CST 2020
*/
@Repository
public interface AccountDao extends JpaRepository<Account, Long> {

    Account findByVipNo(long vipNo);

}