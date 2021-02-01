package com.wenlinzou.tank;

import java.awt.*;

/**
 * description：
 *
 * @author wenlinzou
 * @date 2021/1/23
 */
public abstract class GameObject {
    public int x, y;

    public abstract void paint(Graphics g);

    public abstract int getWidth();

    public abstract int getHeight();
}
