package com.hp.XC;
/*
* 线程中的   阻塞
* 例子：
*  河南电信---- 3000 电信卡  -------中国电信
*  12312434325
*  23523412321
*  12342344345
*  12342343456
*  14353656767
*  13545346567
* */
public class ThreadSleep {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <30 ; i++) {
            Thread.sleep(2); //2毫秒一次
            System.out.println("访问中国电信" + i+"次");
        }
        //其实main方法 就是一个 线程，是一个主线程  main方法的线程就叫main
        Thread thread=Thread.currentThread(); //拿到当前的线程
        String name=thread.getName();   //线程的名字
        System.out.println("name = " + name);
        long id=thread.getId();
        System.out.println("id = " + id);
        
        boolean daemon=thread.isDaemon(); //是否是守护线程  守护线程就相当于是王者中的录视频
        System.out.println("daemon = " + daemon);
        
        int priority=thread.getPriority();
        System.out.println("priority = " + priority);  //线程的优先级
        boolean alive=thread.isAlive();  //看看线程死了没
        System.out.println("alive = " + alive);
    }
}


