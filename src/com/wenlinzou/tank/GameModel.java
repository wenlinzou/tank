package com.wenlinzou.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * description：门面模式
 *
 * @author wenlinzou
 * @date 2021/1/23
 */
public class GameModel {

    Tank myTank = new Tank(200, 400, Dir.UP, Group.GOOD, this);
    java.util.List<Bullet> bulletList = new ArrayList<>();
    java.util.List<Tank> tanks = new ArrayList<>();
    List<Explode> explodes = new ArrayList<>();

    public GameModel() {
        int initTankCount = PropertyMgr.getInt("initTankCount");
        //初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            tanks.add(new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD, this));
        }
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量:" + bulletList.size(), 10, 60);
        g.drawString("敌人的数量:" + tanks.size(), 10, 80);
        g.drawString("爆炸的数量:" + explodes.size(), 10, 100);
        g.setColor(c);

        myTank.paint(g);
        for (int i = 0; i < bulletList.size(); i++) {
            bulletList.get(i).paint(g);
        }

        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }

        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }

        // 碰撞检测
        for (int i = 0; i < bulletList.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                bulletList.get(i).collideWith(tanks.get(j));
            }
        }

//        for (Iterator<Bullet> it= bulletList.iterator(); it.hasNext();) {
//            Bullet bullet = it.next();
//            if (!bullet.isLive()) it.remove();
//        }
    }

    public Tank getMainTank() {
        return myTank;
    }
}
