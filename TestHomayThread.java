package com.hp.XC;
/*
* 练习：测试自已的电脑能看多少个线程
* */
public class TestHomayThread {
    public static int i = 0;

        public static void main(String[] args) {
            while (true){
                Thread t = new XiCaiThread1();
                t.start();
                System.out.println(i++);
            }
        }
    }
    class XiCaiThread1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
