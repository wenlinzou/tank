package com.wenlinzou.tank.observer;

import com.wenlinzou.tank.Tank;

/**
 * description：
 *
 * @author wenlinzou
 * @date 2021/2/11
 */
public class TankFireHandler implements TankFireObserver {
    @Override
    public void actionOnFire(TankFireEvent event) {
        Tank tank = event.getSource();
        tank.fire();
    }
}
