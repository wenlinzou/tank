package com.wenlinzou.tank.strategy;

import com.wenlinzou.tank.Tank;

import java.io.Serializable;

/**
 * description：
 *
 * @author wenlinzou
 * @date 2021/1/18
 */
public interface FireStrategy extends Serializable {
    void fire(Tank tank);
}
