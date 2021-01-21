package com.wenlinzou.tank.abstractfactory;

import com.wenlinzou.tank.Dir;
import com.wenlinzou.tank.Group;
import com.wenlinzou.tank.TankFrame;


/**
 * description：
 *
 * @author wenlinzou
 * @date 2021/1/20
 */
public abstract class GameFactory {
    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tankFrame);

    public abstract BaseExplode createExplode(int x, int y, TankFrame tankFrame);

    public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tankFrame);
}
