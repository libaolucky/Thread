package com.hp.XC;
/*
* 刚刚的 1-2类  是锁在普通方法上的
* 现在 要锁在 静态方法上 ,synchronized 锁 是可以锁在 static静态方法上的
*
* */
public class ThredSynchDemo03 {
    public static void main(String[] args) {
        Thread t1=new Thread(){
            @Override
            public void run() {
                Shop1.buy();
            }
        };

        Thread t2=new Thread(){
            @Override
            public void run() {
                Shop1.buy();
            }
        };
        t1.start();
        t2.start();
    }
}
class Shop1{
    public synchronized static void buy(){
      Thread thread=Thread.currentThread();
        System.out.println(thread.getName()+"选衣服");
        try {
            thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getName()+"试衣服");
        try {
            thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getName()+"出来了！");
    }
}

