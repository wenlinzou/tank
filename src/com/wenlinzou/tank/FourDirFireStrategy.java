package com.wenlinzou.tank;

/**
 * description：
 *
 * @author wenlinzou
 * @date 2021/1/18
 */
public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank tank) {
        int bX = tank.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = tank.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;


        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            new Bullet(bX, bY, dir, tank.group, tank.gameModel);
        }

        if (tank.group == Group.GOOD) {
            new Thread(() -> {
                new Audio("audio/tank_fire.wav").play();
            }).start();
        }
    }
}
