package com.zdw.db;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

/**
*
* @author MBG
* @created Create Time: Tue Jan 28 20:44:44 CST 2020
*/
@Data
public class User {
    /**
     * 主键id
     */
    private Long id;

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
     * 会员编号
     */
    private Long vipNo;

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
    private Boolean sex;

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