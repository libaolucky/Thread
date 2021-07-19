package com.hp.XC;

import java.util.Random;

/*
* 线程的打断
*
*  打断  针对 于线程的 sleep来讲的
*
* 讲解：线程拆炸弹的demo
* */
public class ThreadDemo04 {
    public static int time=4;  //炸弹的倒计时
    public static int password=new Random().nextInt(1000000000);
    public  static boolean boom=true;

    public static void main(String[] args) {
        System.out.println("炸弹的密码是：" + password);

        //第一个线程：炸弹的倒计时，如何 完成倒计时，就 beng  beng
        final Thread boomThread=new Thread(new Runnable() {
            @Override
            public void run() {
            //炸弹的倒计时
                System.out.println("定时炸弹已安装炸弹");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (time >=0){
                    try {
                        if (time == 0) {
                            System.out.println("炸弹 蹦蹦蹦~ 匪徒胜利！");
                            boom=false;
                            break;
                        }
                        time--;
                        System.out.println("time = " + time);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        if(e.getMessage().equals("sleep interrupted")){
                            System.out.println("拆弹成功！");
                            break;
                        }
                        e.printStackTrace();
                    }

                }
            }
        }) ;

        //第二个线程：是 打断线程的倒计时，如果打断了，就 不 beng beng...
        final Thread policeThread=new Thread(new Runnable() {
            @Override
            public void run() {
                //警察负责 拆炸弹 ，因为是模拟  ，所以用 打断的方式 ，打断 boomThread 就可以了
                System.out.println("警察开始破解炸弹的密码！！！");
                while (boom) {
                    if (password == new Random().nextInt(1000000000)){
                        boomThread.interrupt();  //这个是线程的打断。。
                        break;
                    }

                }
            }
        });

        boomThread.start();
        try {
            Thread.sleep(800);
        }catch (InterruptedException e){
        }
        policeThread.start();




    }
}
