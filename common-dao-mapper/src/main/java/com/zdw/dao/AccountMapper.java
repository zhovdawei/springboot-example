package com.zdw.dao;

import com.zdw.db.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
*
* @author MBG
* @created Create Time: Tue Jan 28 05:46:11 CST 2020
*/
@Repository
@Mapper
public interface AccountMapper{

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
     * 根据主键id查询
     * @param id
     */
    Account selectByPrimaryKey(Long id);

    List<Account> selectAll();

    /**
     * 修改数据
     * @param record
     */
    int updateByPrimaryKey(Account record);
}