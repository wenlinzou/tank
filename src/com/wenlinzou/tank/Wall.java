package com.wenlinzou.tank;

import java.awt.*;

/**
 * description：
 *
 * @author wenlinzou
 * @date 2021/1/26
 */
public class Wall extends GameObject {

    int w, h;

    public Rectangle rectangle;

    public Wall(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        this.rectangle = new Rectangle(x, y, w, h);

//        GameModel.getInstance().add(this);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, w, h);
        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return w;
    }

    @Override
    public int getHeight() {
        return h;
    }
}
