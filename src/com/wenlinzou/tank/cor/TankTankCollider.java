package com.wenlinzou.tank.cor;

import com.wenlinzou.tank.GameObject;
import com.wenlinzou.tank.Tank;

/**
 * description：
 *
 * @author wenlinzou
 * @date 2021/1/23
 */
public class TankTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank tank1 = (Tank) o1;
            Tank tank2 = (Tank) o2;
            collideWith(tank1, tank2);
        }
        return true;
    }

    private void collideWith(Tank tank1, Tank tank2) {

        if (tank1.getRectangle().intersects(tank2.getRectangle())) {
            tank1.back();
            tank2.back();
        }
    }
}
