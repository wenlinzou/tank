package com.wenlinzou.tank;

/**
 * description：
 *
 * @author wenlinzou
 * @date 2020/12/28
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();

        while (true) {
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }
}
