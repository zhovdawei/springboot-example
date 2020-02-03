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
@Table(name="refund_detail")
public class RefundDetail {
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
     * 会员账户号
     */
    @Basic
    @Column(name="vip_no")
    private Long vipNo;

    /**
     * 支付额度(积分除以100)
     */
    @Basic
    @Column(name="money")
    private BigDecimal money;

    /**
     * 退还方式(1-余额,2-积分,3-支付宝,4-微信,5-苹果支付,6-信用卡,7-储值卡)
     */
    @Basic
    @Column(name="refund_way")
    private Integer refundWay;

    /**
     * 退还类型(0-单一退还,1-混合退还)
     */
    @Basic
    @Column(name="refund_type")
    private Integer refundType;

    /**
     * 退款流水号
     */
    @Basic
    @Column(name="serial_number")
    private Long serialNumber;

    /**
     * 创建时间
     */
    @Basic
    @Column(name="create_time")
    private LocalDateTime createTime;
}