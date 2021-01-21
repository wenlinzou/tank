package com.wenlinzou.tank.abstractfactory;

import com.wenlinzou.tank.Audio;
import com.wenlinzou.tank.ResourceMgr;
import com.wenlinzou.tank.TankFrame;

import java.awt.*;

/**
 * description：
 *
 * @author wenlinzou
 * @date 2021/1/20
 */
public class RectExplode extends BaseExplode {
    public static final int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static final int HEIGHT = ResourceMgr.explodes[0].getHeight();

    private int x, y;

    //    private boolean living = true;
    private TankFrame tankFrame;

    private int step = 0;

    public RectExplode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
        new Thread(() -> new Audio("audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g) {
//        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x, y, 10 * step, 10 * step);
        step++;

        if (step >= 15) {
            tankFrame.explodes.remove(this);
        }
        g.setColor(c);
    }
}
