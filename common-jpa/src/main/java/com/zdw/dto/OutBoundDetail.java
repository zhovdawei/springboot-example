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
* @created Create Time: Sun Feb 02 03:31:08 CST 2020
*/
@Data
@Entity
@Table(name="out_bound_detail")
public class OutBoundDetail {
    /**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    /**
     * 出库单号
     */
    @Basic
    @Column(name="out_id")
    private Long outId;

    /**
     * 产品id
     */
    @Basic
    @Column(name="product_id")
    private Long productId;

    /**
     * 数量
     */
    @Basic
    @Column(name="total")
    private Integer total;

    /**
     * 
     */
    @Basic
    @Column(name="create_time")
    private LocalDateTime createTime;
}