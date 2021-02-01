package com.wenlinzou.tank.decorator;

import com.wenlinzou.tank.GameObject;

import java.awt.*;

/**
 * description：
 *
 * @author wenlinzou
 * @date 2021/1/31
 */
public class RectDecorator extends GODecorator {

    public RectDecorator(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void paint(Graphics g) {
        this.x = gameObject.x;
        this.y = gameObject.y;
        gameObject.paint(g);

        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.drawRect(super.gameObject.x, super.gameObject.y, getWidth(), getHeight());
        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return super.gameObject.getWidth();
    }

    @Override
    public int getHeight() {
        return super.gameObject.getHeight();
    }
}
