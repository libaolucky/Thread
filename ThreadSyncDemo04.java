package com.hp.XC;
/*
*  互斥锁  各干各的 你不碍我 我不碍你
* */
public class ThreadSyncDemo04 {
    public static void main(String[] args) {
        Shop2 shop2=new Shop2();
        Thread t1=new Thread(){
            @Override
            public void run() {
                try {
                    shop2.buy();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t2=new Thread(){
            @Override
            public void run() {
                try {
                    shop2.buy2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        t2.start();
    }

}
class Shop2 {
    //如果，不加上  synchronized锁，完了  会火。。。
    public void buy() throws InterruptedException {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "正在选衣服");
        Thread.sleep(5000);

        synchronized (this) {  //使用 synchronized 块，锁在关键位置  锁在优衣库的试衣间上了
            System.out.println(thread.getName() + "进入试衣间  试衣服");
            Thread.sleep(5000);
            System.out.println("试完衣服 over");
        }
    }
     //买冰淇淋，在优衣库对面
    public synchronized void buy2() throws InterruptedException {
           Thread thread1=Thread.currentThread();
            System.out.println(thread1.getName()+"买冰淇淋");
        }
    }

