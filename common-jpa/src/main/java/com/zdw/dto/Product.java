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
@Table(name="product")
public class Product {
    /**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    /**
     * 产品编号
     */
    @Basic
    @Column(name="product_id")
    private Long productId;

    /**
     * 名称
     */
    @Basic
    @Column(name="name")
    private String name;

    /**
     * 单价
     */
    @Basic
    @Column(name="price")
    private BigDecimal price;

    /**
     * 类型(1-电子,2-水果,3-日用,4-零食,5-饮品,6-化妆品,7-衣服,8-鞋,9-水产)
     */
    @Basic
    @Column(name="type")
    private Integer type;

    /**
     * 创建时间
     */
    @Basic
    @Column(name="create_time")
    private LocalDateTime createTime;
}