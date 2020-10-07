package com.aoki.mall.common.utils;

/**
 * Redis所有Keys
 *
 * @author Leo
 */
public class RedisKeys {

    public static String getSysConfigKey(String key){
        return "sys:config:" + key;
    }
}
