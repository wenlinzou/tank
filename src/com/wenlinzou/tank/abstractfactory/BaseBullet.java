package com.wenlinzou.tank.abstractfactory;

import com.wenlinzou.tank.Tank;

import java.awt.*;

/**
 * description：
 *
 * @author wenlinzou
 * @date 2021/1/20
 */
public abstract class BaseBullet {
    public abstract void paint(Graphics g);

    public abstract void collideWith(Tank tank);
}
