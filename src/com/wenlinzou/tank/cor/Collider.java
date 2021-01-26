package com.wenlinzou.tank.cor;

import com.wenlinzou.tank.GameObject;

public interface Collider {
    boolean collide(GameObject o1, GameObject o2);
}
