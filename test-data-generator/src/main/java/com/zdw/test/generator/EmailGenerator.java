package com.zdw.test.generator;

import com.zdw.test.util.PinyinUtil;
import com.zdw.test.util.RandomUtil;

public class EmailGenerator {

    private static final String[] email_suffix = ("@gmail.com,@yahoo.com,@msn.com,@hotmail.com,@aol.com," +
                                                  "@ask.com,@live.com,@qq.com,@0355.net,@163.com,@163.net," +
                                                  "@263.net,@3721.net,@yeah.net,@googlemail.com,@126.com," +
                                                  "@sina.com,@sohu.com,@yahoo.com.cn").split(",");

    /**
     * 返回Email
     *
     * @param name 姓名
     * @return
     */
    public static String getEmail(String name) {
        StringBuffer sb = new StringBuffer();
        sb.append(PinyinUtil.namePinYin(name));
        sb.append(RandomUtil.getNum(6));
        sb.append(email_suffix[(int) (Math.random() * email_suffix.length)]);
        return sb.toString();
    }

}