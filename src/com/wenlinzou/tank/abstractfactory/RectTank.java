package com.wenlinzou.tank.abstractfactory;

import com.wenlinzou.tank.*;

import java.awt.*;
import java.util.Random;

/**
 * description：
 *
 * @author wenlinzou
 * @date 2020/12/31
 */
public class RectTank extends BaseTank {

    private static final int SPEED = 2;

    public static final int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static final int HEIGHT = ResourceMgr.goodTankU.getHeight();

    public Rectangle rectangle = new Rectangle();

    private Random random = new Random();

    int x, y;
    Dir dir = Dir.DOWN;

    private boolean moving = true;
    TankFrame tankFrame;
    private boolean living = true;
    Group group = Group.BAD;

    FireStrategy fireStrategy;

    public RectTank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankFrame = tankFrame;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;

        if (group == Group.GOOD) {
            String goodFSName = PropertyMgr.getString("goodFS");
            try {
                fireStrategy = (FireStrategy) Class.forName(goodFSName).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            fireStrategy = new DefaultFireStrategy();
        }
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public void paint(Graphics g) {
        if (!living) {
            tankFrame.tanks.remove(this);
        }

//        switch (dir) {
//            case LEFT:
//                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
//                break;
//            case UP:
//                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
//                break;
//            case RIGHT:
//                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
//                break;
//            case DOWN:
//                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
//                break;
//            default:
//                break;
//        }

        Color c = g.getColor();
        g.setColor(group == Group.GOOD ? Color.RED : Color.BLUE);
        g.fillRect(x, y, 40, 40);
        g.setColor(c);

        move();

    }

    private void move() {
        if (!moving) {
            return;
        }
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }

        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            this.fire();
        }

        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            randomDir();
        }
        boundsCheck();

        // update rectangle
        rectangle.x = this.x;
        rectangle.y = this.y;

    }

    private void boundsCheck() {
        if (this.x < 2) {
            x = 2;
        }
        if (this.y < 28) {
            y = 28;
        }
        if (this.x > TankFrame.GAME_WIDTH - RectTank.WIDTH - 2) {
            x = TankFrame.GAME_WIDTH - RectTank.WIDTH - 2;
        }
        if (this.y > TankFrame.GAME_HEIGHT - RectTank.HEIGHT - 2) {
            y = TankFrame.GAME_HEIGHT - RectTank.HEIGHT - 2;
        }

    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }


    public void fire() {
//        fireStrategy.fire(this);
        int bX = this.x + RectTank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = this.y + RectTank.HEIGHT / 2 - Bullet.HEIGHT / 2;


        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            tankFrame.gameFactory.createBullet(bX, bY, dir, group, tankFrame);
        }

        if (this.group == Group.GOOD) {
            new Thread(() -> {
                new Audio("audio/tank_fire.wav").play();
            }).start();
        }
    }

    @Override
    public void die() {
        this.living = false;
    }
}
