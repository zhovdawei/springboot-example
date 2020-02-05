package com.zdw.test.util;

public class RandomUtil {

    /**
     * @param start 区间开始
     * @param end 区间结束
     * */
    public static int getNum(int start, int end) {
        return (int) (Math.random() * (end - start + 1) + start);
    }

    /**
     * @param num 几位数字字串
     * */
    public static String getNum(int num){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            sb.append(getNum(0,9));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i <50 ; i++) {
            System.out.println(getNum(3));
        }
    }
}
