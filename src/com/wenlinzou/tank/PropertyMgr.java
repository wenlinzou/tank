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

    // getInt
    public static int getInt(String key) {
        Object obj = get(key);
        if (null != obj) {
            return Integer.parseInt((String) obj);
        }
        return -1;
    }

    // getString

    public static void main(String[] args) {
        System.out.println(PropertyMgr.get("initTankCount"));
    }
}
