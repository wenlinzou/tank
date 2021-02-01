package com.wenlinzou.tank.strategy;

import com.wenlinzou.tank.*;
import com.wenlinzou.tank.decorator.RectDecorator;
import com.wenlinzou.tank.decorator.TailDecorator;

/**
 * description：
 *
 * @author wenlinzou
 * @date 2021/1/18
 */
public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank tank) {
        int bX = tank.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = tank.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;

//        GameModel.getInstance().add(
//                new RectDecorator(
//                        new TailDecorator(
//                        new Bullet(bX, bY, tank.dir, tank.group))));

        new Bullet(bX,bY,tank.dir,tank.group);

        if (tank.group == Group.GOOD) {
            new Thread(() -> {
                new Audio("audio/tank_fire.wav").play();
            }).start();
        }
    }
}
