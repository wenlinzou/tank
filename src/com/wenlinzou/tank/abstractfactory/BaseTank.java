package com.wenlinzou.tank.abstractfactory;

import com.wenlinzou.tank.Group;

import java.awt.*;

/**
 * description：
 *
 * @author wenlinzou
 * @date 2021/1/20
 */
public abstract class BaseTank {
    public Group group = Group.BAD;
    public Rectangle rectangle = new Rectangle();

    public abstract void paint(Graphics g);

    public Group getGroup() {
        return this.group;
    }

    public abstract void die();

    public abstract int getX();

    public abstract int getY();
}
