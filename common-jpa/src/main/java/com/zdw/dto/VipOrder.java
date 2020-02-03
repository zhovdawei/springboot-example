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
* @created Create Time: Sun Feb 02 03:31:08 CST 2020
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
     * 订单状态(0-未支付,1-已支付,2-配货中,3-运输中,4-已送达,5-已收货,6-已取消,7-退款中,8-已退款)
     */
    @Basic
    @Column(name="status")
    private Integer status;

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