package com.wenlinzou.tank.abstractfactory;

import com.wenlinzou.tank.Bullet;
import com.wenlinzou.tank.Dir;
import com.wenlinzou.tank.Group;
import com.wenlinzou.tank.TankFrame;

/**
 * description：
 *
 * @author wenlinzou
 * @date 2021/1/20
 */
public class RectFactory extends GameFactory{
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return null;
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tankFrame) {
        return new RectExplode(x, y, tankFrame);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new RectBullet(x, y, dir, group, tankFrame);
    }
}
