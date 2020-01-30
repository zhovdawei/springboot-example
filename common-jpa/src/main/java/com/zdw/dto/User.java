package com.zdw.dto;

import java.time.LocalDate;
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
* @created Create Time: Fri Jan 31 04:44:48 CST 2020
*/
@Data
@Entity
@Table(name="user")
public class User {
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
     * 姓名
     */
    @Basic
    @Column(name="name")
    private String name;

    /**
     * 身份号码
     */
    @Basic
    @Column(name="number")
    private String number;

    /**
     * 网络昵称
     */
    @Basic
    @Column(name="nickname")
    private String nickname;

    /**
     * 邮箱绑定
     */
    @Basic
    @Column(name="email")
    private String email;

    /**
     * 手机绑定
     */
    @Basic
    @Column(name="phone")
    private String phone;

    /**
     * 性别(0-男,1-女)
     */
    @Basic
    @Column(name="sex")
    private Integer sex;

    /**
     * 生日
     */
    @Basic
    @Column(name="birthday")
    private LocalDate birthday;

    /**
     * 创建日期
     */
    @Basic
    @Column(name="create_time")
    private LocalDateTime createTime;

    /**
     * 更新日期
     */
    @Basic
    @Column(name="update_time")
    private LocalDateTime updateTime;
}