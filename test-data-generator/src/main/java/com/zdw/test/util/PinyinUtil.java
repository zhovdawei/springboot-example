package com.zdw.test.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import org.apache.commons.lang.StringUtils;

public class PinyinUtil {
    
    public static String namePinYin(String name){
        char[] names = name.toCharArray();
        StringBuffer tempPinying = new StringBuffer();
        for (char c : names) {
            String str = getPinYin(c);
            if(!StringUtils.isBlank(str)){
                char charLast = str.charAt(str.length()-1);
                if(charLast<65){
                    tempPinying.append(str.substring(0, str.length()-1));
                }else {
                    tempPinying.append(str);
                }
            }
        }
        return tempPinying.toString();
    }

    public static String getPinYin(char word){
        String[] strs = PinyinHelper.toHanyuPinyinStringArray(word);
        if(strs!=null && strs.length>0){
            return strs[0];
        }
        return "";
    }

}
