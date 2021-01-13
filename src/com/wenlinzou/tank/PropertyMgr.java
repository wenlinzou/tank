package com.wenlinzou.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * description：
 *
 * @author wenlinzou
 * @date 2021/1/13
 */
public class PropertyMgr {
    static Properties properties = new Properties();

    static {
        try {
            properties.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        if (null == properties) {
            return null;
        }
        return properties.get(key);
    }

    public static void main(String[] args) {
        System.out.println(PropertyMgr.get("initTankCount"));
    }
}
