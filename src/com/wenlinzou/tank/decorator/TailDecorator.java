package com.wenlinzou.tank.decorator;

import com.wenlinzou.tank.GameObject;

import java.awt.*;

/**
 * description：
 *
 * @author wenlinzou
 * @date 2021/1/31
 */
public class TailDecorator extends GODecorator {

    public TailDecorator(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void paint(Graphics g) {
        this.x = gameObject.x;
        this.y = gameObject.y;
        gameObject.paint(g);

        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.drawLine(super.gameObject.x, super.gameObject.y, super.gameObject.x+getWidth(), super.gameObject.y+getHeight());
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
