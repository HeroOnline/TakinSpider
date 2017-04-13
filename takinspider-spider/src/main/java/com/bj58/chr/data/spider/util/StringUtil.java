package com.bj58.chr.data.spider.util;

/**
 * 
 * @author WangYazhou
 * @date  2015年11月14日 上午11:34:15
 * @see
 */
public abstract class StringUtil {

    public static boolean isNullOrEmpty(String value) {
        if (null == value || value.length() < 1 || "null".equals(value.toLowerCase())) {
            return true;
        }
        return false;
    }

    public static boolean isNotNullOrEmpty(String value) {
        return !isNullOrEmpty(value);
    }

}
