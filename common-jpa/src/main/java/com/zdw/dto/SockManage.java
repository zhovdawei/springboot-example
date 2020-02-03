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
@Table(name="stock_manage")
public class SockManage {
    /**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    /**
     * 产品Id
     */
    @Basic
    @Column(name="product_id")
    private Long productId;

    /**
     * 库存数量
     */
    @Basic
    @Column(name="total")
    private Integer total;

    /**
     * 状态(0-未上架,1-在售,2-售空)
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