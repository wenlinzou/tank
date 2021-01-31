package com.wenlinzou.tank.cor;

import com.wenlinzou.tank.GameObject;
import com.wenlinzou.tank.Tank;
import com.wenlinzou.tank.Wall;

/**
 * description：
 *
 * @author wenlinzou
 * @date 2021/1/23
 */
public class TankWallCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Wall) {
            Tank tank = (Tank) o1;
            Wall wall = (Wall) o2;
            collideWith(tank, wall);
        } else if (o1 instanceof Wall && o2 instanceof Tank) {
            return collide(o2, o1);
        }
        return true;

    }

    public void collideWith(Tank tank, Wall wall) {

        if (tank.getRectangle().intersects(wall.getRectangle())) {
            tank.back();
        }

    }
}
