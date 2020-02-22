package com.zdw.dto;

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
* @created Create Time: Thu Feb 06 15:01:20 CST 2020
*/
@Data
@Entity
@Table(name="out_bound_order")
public class OutBoundOrder {
    /**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    /**
     * 订单号
     */
    @Basic
    @Column(name="order_id")
    private Long orderId;

    /**
     * 出库单号
     */
    @Basic
    @Column(name="out_id")
    private Long outId;

    /**
     * 状态(0-创建出库单,1-准备货品中,2-已出库)
     */
    @Basic
    @Column(name="status")
    private Integer status;

    /**
     * 创建时间时间
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