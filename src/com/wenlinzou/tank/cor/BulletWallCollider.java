package com.wenlinzou.tank.cor;

import com.wenlinzou.tank.*;

/**
 * description：
 *
 * @author wenlinzou
 * @date 2021/1/23
 */
public class BulletWallCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Wall) {
            Bullet bullet = (Bullet) o1;
            Wall wall = (Wall) o2;
            collideWith(bullet, wall);
        } else if (o1 instanceof Wall && o2 instanceof Bullet) {
            return collide(o2, o1);
        }
        return true;

    }

    public void collideWith(Bullet bullet, Wall wall) {

        if (bullet.getRectangle().intersects(wall.getRectangle())) {
            bullet.die();
        }

    }
}
