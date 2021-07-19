package com.hp.XC;
/*
*  多个线程同时操作一个资源诞生的  安全问题
*  比如：多个 账户抢票。synchronized可以解决  多想吃饭的 安全问题
*  synchronized 锁的机制  可以解决  多线程的安全问题
*  解决的手段是 将 原本的  多个线程  “各干各的” 变为  按顺序执行
*  未加  synchronized 锁 之间，  线程是异步的 ，给方法加上 ynchronized锁 就变成了同步
*   将  有序的同步执行  就会  解决安全问题，但是  缺点是因为 有序，需要等待  方法内的程序 走完
*   才进行下一个线程  所以  效率上会慢点
*
*   synchronized 锁  锁在不同位置，起到不同的效果
*
* */
public class ThreadSyncDemo01 {
    public static void main(String[] args) {
        Tickets tickets=new Tickets();
        Runnable target;
        Thread t1=new Thread(){
            @Override
            public void run() {
                //模拟  黄牛1 取票
                while(true){
                    int ticket=tickets.getTicket();
                   // Thread.yield();  //线程让一让
                    System.out.println(getName()+"线程拿了"+ticket);
                }
            }
        };

        Thread t2=new Thread(){
            @Override
            public void run() {
                //模拟  黄牛2 取票
                while(true){
                    int ticket=tickets.getTicket();
                    //Thread.yield();  //线程让一让
                    System.out.println(getName()+"线程拿了"+ticket);

                }
            }
        };
        t1.start();
        t2.start();

    }
}
class Tickets{
    private int ticket=20;

    public synchronized int getTicket() {
        if(ticket ==0){
            System.out.println("票没有了啊，亲");
            throw new RuntimeException("票某了！");
        }
        Thread.yield();  //线程让一让
        return ticket--;
    }

}
