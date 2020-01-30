package com.zdw.dao;

import com.zdw.db.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
*
* @author MBG
* @created Create Time: Thu Jan 30 02:58:10 CST 2020
*/
@Mapper
@Repository
public interface AccountMapper {
    /**
     * 根据主键删除数据
     * @param id
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入数据库记录（不建议使用）
     * @param record
     */
    int insert(Account record);

    /**
     * 插入数据库记录（建议使用）
     * @param record
     */
    int insertSelective(Account record);

    /**
     * 根据主键id查询
     * @param id
     */
    Account selectByPrimaryKey(Long id);

    /**
     * 修改数据(推荐使用)
     * @param record
     */
    int updateByPrimaryKeySelective(Account record);

    /**
     * 修改数据
     * @param record
     */
    int updateByPrimaryKey(Account record);
}