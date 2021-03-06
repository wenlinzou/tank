package com.wenlinzou.tank.observer;

import java.io.Serializable;

/**
 * description：
 *
 * @author wenlinzou
 * @date 2021/2/11
 */
public interface TankFireObserver extends Serializable {
    void actionOnFire(TankFireEvent event);
}
