package com.zdw.test.generator;

import com.zdw.test.util.RandomUtil;

/**
 * 随机生成手机号
 * 代码源于网络 由kingYiFan整理  create2019/05/24
 */
public class PhoneGenerator {
    /**
     * 返回手机号码
     */
    private static String[] telFirst = ("134,135,136,137,138,139,150,151,152,157,158,159,178,182,183,184,187,188,198" +
            ",130,131,132,155,156,166,175,176,185,186" +
            ",133,153,173,174,177,180,181,189,191,199").split(",");

    public static String getTel() {
        int index = RandomUtil.getNum(0, telFirst.length - 1);
        String first = telFirst[index];
        String second = String.valueOf(RandomUtil.getNum(999, 8888) + 10000).substring(1);
        String third = String.valueOf(RandomUtil.getNum(1, 9999) + 10000).substring(1);
        return first + second + third;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            String tel = getTel();
            System.out.println(tel);
        }
    }
}