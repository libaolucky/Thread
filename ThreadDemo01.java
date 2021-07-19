package com.hp.XC;
/*
*  线程：
*  以前代码都是 自上到下的执行，那么  我想有个分支
*
*  线程的  第一种方式：  缺点：直接extends Thread  ,那么浪费一次继承的机会
* */
public class ThreadDemo01 {
    public static void main(String[] args) {
        Thread t1=new HotWaterThread();   //烧水的线程
        Thread t2=new xiCaiThread();   //洗菜的线程

        t1.start();
        t2.start();
        //像这样  做1会儿洗菜，做一会  烧水 ，那么这就叫做  异步  ，没有先后顺序，ajax异步的
        //如果是 吧烧水全部完成，再做洗菜，这叫做  同步，同步是有先后顺序的
    }
}
//如果只单单 new  Thread,它只是一个线程，线程中没有方法（任务），没意义。
//需要自已创建一个线程，继承他的任务（方法）
//线程中  最有意义的就是  run方法
class HotWaterThread extends Thread{
    //重要的方法   线程的run方法！！！
    //烧水
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("烧了 " + i+"瓶水");
        }
    }
}

class xiCaiThread extends Thread{
    //洗菜
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("洗了 " + i+"颗大白菜菜");
        }
    }
}

