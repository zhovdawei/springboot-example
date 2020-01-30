package com.zdw.db;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
*
* @author MBG
* @created Create Time: Thu Jan 30 02:58:10 CST 2020
*/
@Data
public class User {
    /**
     * 
     */
    private Long id;

    /**
     * 会员编号
     */
    private Long vipNo;

    /**
     * 姓名
     */
    private String name;

    /**
     * 身份号码
     */
    private String number;

    /**
     * 网络昵称
     */
    private String nickname;

    /**
     * 邮箱绑定
     */
    private String email;

    /**
     * 手机绑定
     */
    private String phone;

    /**
     * 性别(0-男,1-女)
     */
    private Integer sex;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 创建日期
     */
    private LocalDateTime createTime;

    /**
     * 更新日期
     */
    private LocalDateTime updateTime;
}