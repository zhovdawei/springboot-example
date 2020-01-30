package com.zdw.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
*
* @author MBG
* @created Create Time: Fri Jan 31 04:47:59 CST 2020
*/
@Data
@Entity
@Table(name="account")
public class Account {
    /**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    /**
     * 会员编号
     */
    @Basic
    @Column(name="vip_no")
    private Long vipNo;

    /**
     * 余额
     */
    @Basic
    @Column(name="balance")
    private BigDecimal balance;

    /**
     * 积分
     */
    @Basic
    @Column(name="integral")
    private Integer integral;

    /**
     * 会员等级(0-普通会员,1-青铜会员,2-白银会员,3-黄金会员,4-铂金会员,5-钻石会员,6-至尊会员)
     */
    @Basic
    @Column(name="grade")
    private Integer grade;

    /**
     * 创建时间
     */
    @Basic
    @Column(name="create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @Basic
    @Column(name="update_time")
    private LocalDateTime updateTime;
}