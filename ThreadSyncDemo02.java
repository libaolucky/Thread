package com.hp.XC;
/*
* synchronized 锁  尽量锁在  范围小的位置上
*越小 效率越高
*
* 优衣库；
*   synchronized 锁在方法上， 那么  如果方法中有 可以多个线程共同使用的，那么 会造成锁的浪费
*   降低效率 ，  锁应该 锁在 关键位置
 * */
public class ThreadSyncDemo02 {
    public static void main(String[] args) {
        Shop shop=new Shop();
        Thread t1=new Thread(){
            @Override
            public void run() {
                try {
                    shop.buy();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t2=new Thread(){
            @Override
            public void run() {
                try {
                    shop.buy();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        t2.start();
    }
}

class Shop{
        //如果，不加上  synchronized锁，完了  会火。。。
        public  void buy() throws InterruptedException {
            Thread thread=Thread.currentThread();

            System.out.println(thread.getName()+"正在选衣服");
            Thread.sleep(5000);

            synchronized(this) {  //使用 synchronized 块，锁在关键位置  锁在优衣库的试衣间上了
                System.out.println(thread.getName()+"进入试衣间  试衣服");
                Thread.sleep(5000);
                System.out.println("试完衣服 over");
            }
        }
}