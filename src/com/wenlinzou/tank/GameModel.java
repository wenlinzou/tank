package com.wenlinzou.tank;

import com.wenlinzou.tank.cor.ColliderChain;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * description：门面模式
 *
 * @author wenlinzou
 * @date 2021/1/23
 */
public class GameModel {

    private static final GameModel INSTANCE = new GameModel();

    static {
        INSTANCE.init();
    }

    public static GameModel getInstance() {
        return INSTANCE;
    }

    Tank myTank;

    //    List<Bullet> bulletList = new ArrayList<>();
//    List<Tank> tanks = new ArrayList<>();
//    List<Explode> explodes = new ArrayList<>();
    ColliderChain chain = new ColliderChain();

    private List<GameObject> objects = new ArrayList<>();

    private GameModel() {

    }

    private void init() {
        //初始化主战坦克
        myTank = new Tank(200, 400, Dir.UP, Group.GOOD);

        int initTankCount = PropertyMgr.getInt("initTankCount");
        //初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD);
        }

        //初始化墙
        add(new Wall(150, 150, 200, 50));
        add(new Wall(550, 150, 200, 50));
        add(new Wall(300, 300, 50, 200));
        add(new Wall(550, 300, 50, 200));
    }

    public void add(GameObject gameObject) {
        this.objects.add(gameObject);
    }

    public void remove(GameObject gameObject) {
        this.objects.remove(gameObject);
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
//        g.drawString("子弹的数量:" + bulletList.size(), 10, 60);
//        g.drawString("敌人的数量:" + tanks.size(), 10, 8 0);
//        g.drawString("爆炸的数量:" + explodes.size(), 10, 100);
        g.setColor(c);

        myTank.paint(g);
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }

        //互相碰撞
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i + 1; j < objects.size(); j++) {
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
                chain.collide(o1, o2);
            }
        }

        // 碰撞检测
//        for (int i = 0; i < bulletList.size(); i++) {
//            for (int j = 0; j < tanks.size(); j++) {
//                bulletList.get(i).collideWith(tanks.get(j));
//            }
//        }


    }

    public Tank getMainTank() {
        return myTank;
    }

    public void save() {
        File file = new File("/Users/liumengqi/Desktop/tank.data");
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(myTank);
            objectOutputStream.writeObject(objects);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != objectOutputStream) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void load() {
        File file = new File("/Users/liumengqi/Desktop/tank.data");
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            myTank = (Tank) objectInputStream.readObject();
            objects = (List) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (null != objectInputStream) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
