package com.wenlinzou.tank.observer;

import com.wenlinzou.tank.Tank;

/**
 * description：
 *
 * @author wenlinzou
 * @date 2021/2/11
 */
public class TankFireEvent {
    Tank tank;

    public Tank getSource() {
        return tank;
    }

    public TankFireEvent(Tank tank) {
        this.tank = tank;
    }
}
