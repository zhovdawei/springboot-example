package com.zdw.db;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
*
* @author MBG
* @created Create Time: Thu Jan 30 02:58:10 CST 2020
*/
@Data
public class Account {
    /**
     * 
     */
    private Long id;

    /**
     * 会员编号
     */
    private Long vipNo;

    /**
     * 余额
     */
    private BigDecimal balance;

    /**
     * 积分
     */
    private Integer integral;

    /**
     * 会员等级(0-普通会员,1-青铜会员,2-白银会员,3-黄金会员,4-铂金会员,5-钻石会员,6-至尊会员)
     */
    private Integer grade;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}