package com.hp.XC;
/*
* 创建线程的第二种方式，继承，用实现
* */
public class ThreadDemo02 {
    public static void main(String[] args) {
        Runnable xicai = new XiCai();
        Runnable shoshui = new ShaoShui();

        Thread xicaiThread = new Thread(xicai);
        Thread ShaoshuiThread = new Thread(shoshui);

        xicaiThread.start();
        ShaoshuiThread.start();
    }
}
class XiCai implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            System.out.println("洗了菜" + i);
        }
    }
}
class ShaoShui implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            System.out.println("烧水" + i);
        }
    }
}
