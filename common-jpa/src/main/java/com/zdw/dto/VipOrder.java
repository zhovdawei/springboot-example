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
* @created Create Time: Thu Feb 06 14:27:36 CST 2020
*/
@Data
@Entity
@Table(name="vip_order")
public class VipOrder {
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
     * 会员编号
     */
    @Basic
    @Column(name="vip_no")
    private Long vipNo;

    /**
     * 订单总额
     */
    @Basic
    @Column(name="pay_sum")
    private BigDecimal paySum;

    /**
     * 订单状态(0-未支付,1-已支付,2-退款中,3-已退款,4-已取消)
     */
    @Basic
    @Column(name="status")
    private Integer status;

    /**
     * 收货人
     */
    @Basic
    @Column(name="pick_user")
    private String pickUser;

    /**
     * 收货人手机号
     */
    @Basic
    @Column(name="pick_phone")
    private String pickPhone;

    /**
     * 收货地址
     */
    @Basic
    @Column(name="pick_address")
    private String pickAddress;

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