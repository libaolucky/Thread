package com.hp.XC;
/*
* 线程的创建的  最好用的  匿名内部类
* 线程创建的方式3
* */
public class ThreadDemo03 {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i <100 ; i++) {
                    System.out.println("洗了"+i+"颗菜");
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i <100 ; i++) {
                    System.out.println("烧了"+i+"瓶水");
                }
            }
        }.start();
    }
}
