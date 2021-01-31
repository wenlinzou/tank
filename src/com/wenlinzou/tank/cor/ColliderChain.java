package com.wenlinzou.tank.cor;

import com.wenlinzou.tank.GameObject;

import java.util.LinkedList;
import java.util.List;

/**
 * description：
 *
 * @author wenlinzou
 * @date 2021/1/24
 */
public class ColliderChain implements Collider {
    private List<Collider> colliderList = new LinkedList<>();

    public ColliderChain() {
        add(new BulletTankCollider());
        add(new TankTankCollider());
        add(new BulletWallCollider());
        add(new TankWallCollider());
    }

    public void add(Collider c) {
        colliderList.add(c);
    }

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliderList.size(); i++) {
            if (!colliderList.get(i).collide(o1, o2)) {
                return false;
            }
        }
        return true;
    }
}
