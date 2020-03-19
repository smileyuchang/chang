package com.chang.common.util;

/**
 * Redis所有Keys
 * @since 3.0.0 2017-07-18
 */
public class RedisKeys {

    public static String getSysConfigKey(String key){
        return "sys:config:" + key;
    }

    public static String getShiroSessionKey(String key){
        return "sessionid:" + key;
    }
}
