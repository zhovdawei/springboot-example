package com.zdw.dao;

import com.zdw.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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

    /**
     * 这里有个大坑，@Query里面的元素应该使用Entity里面的命名，然后由Entity自动去映射table
     * */
    @Transactional
    @Modifying
    @Query("UPDATE User SET name = ?2 WHERE vipNo = ?1")
    int updateNameByVipNo(Long vipNo,String name);

    User findById(long id);

}