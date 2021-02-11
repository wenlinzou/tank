package com.wenlinzou.tank.observer;

/**
 * description：
 *
 * @author wenlinzou
 * @date 2021/2/11
 */
public interface TankFireObserver {
    void actionOnFire(TankFireEvent event);
}
