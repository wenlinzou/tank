package com.wenlinzou.tank.abstractfactory;

import com.wenlinzou.tank.*;

import java.awt.*;

/**
 * description：
 *
 * @author wenlinzou
 * @date 2020/12/31
 */
public class RectBullet extends BaseBullet {
    private static final int SPEED = 10;
    public static final int WIDTH = ResourceMgr.bulletD.getWidth();
    public static final int HEIGHT = ResourceMgr.bulletD.getHeight();

    Rectangle rectangle = new Rectangle();

    private int x, y;
    private Dir dir;

    private boolean living = true;
    private TankFrame tankFrame;
    private Group group = Group.BAD;

    public RectBullet(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankFrame = tankFrame;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;

        tankFrame.bulletList.add(this);
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void paint(Graphics g) {
        if (!living) {
            tankFrame.bulletList.remove(this);
        }

//        switch (dir) {
//            case LEFT:
//                g.drawImage(ResourceMgr.bulletL, x, y, null);
//                break;
//            case UP:
//                g.drawImage(ResourceMgr.bulletU, x, y, null);
//                break;
//            case RIGHT:
//                g.drawImage(ResourceMgr.bulletR, x, y, null);
//                break;
//            case DOWN:
//                g.drawImage(ResourceMgr.bulletD, x, y, null);
//                break;
//            default:
//                break;
//        }
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 20, 20);
        g.setColor(c);

        move();

    }

    private void move() {
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

        // update rectangle
        rectangle.x = this.x;
        rectangle.y = this.y;


        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            living = false;
        }

    }

    public void collideWith(Tank tank) {
        if (this.group == tank.getGroup()) {
            return;
        }

        if (rectangle.intersects(tank.rectangle)) {
            tank.die();
            this.die();

            int eX = tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
            int eY = tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
            tankFrame.explodes.add(tankFrame.gameFactory.createExplode(eX, eY, tankFrame));
        }

    }

    private void die() {
        this.living = false;
    }
}
