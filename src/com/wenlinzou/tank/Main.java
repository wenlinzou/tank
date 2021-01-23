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



        new Thread(() -> {
            new Audio("audio/war1.wav").loop();
        }).start();

        while (true) {
            Thread.sleep(25);
            tankFrame.repaint();
        }
    }
}
