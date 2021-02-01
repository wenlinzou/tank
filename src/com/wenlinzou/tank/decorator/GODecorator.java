package com.wenlinzou.tank.decorator;

import com.wenlinzou.tank.GameObject;

import java.awt.*;

/**
 * description：
 *
 * @author wenlinzou
 * @date 2021/1/31
 */
public abstract class GODecorator extends GameObject {
    GameObject gameObject;

    public GODecorator(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    @Override
    public abstract void paint(Graphics g);

}
