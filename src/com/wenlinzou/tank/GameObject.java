package com.wenlinzou.tank;

import java.awt.*;
import java.io.Serializable;

/**
 * description：
 *
 * @author wenlinzou
 * @date 2021/1/23
 */
public abstract class GameObject implements Serializable {
    public int x, y;

    public abstract void paint(Graphics g);

    public abstract int getWidth();

    public abstract int getHeight();
}
