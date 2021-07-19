package com.hp.XC;

/**
 *  线程的打断
 *  背景:   1, 小白:  爱吃 大肘子,,, 100块.
 *         2, 黑子: 打断 超阳
 */
public class ThreadDemo05 {
    public static void main(String[] args) {
        Thread xiaoBai = new  Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while(true){
                    try {
                        System.out.println("吃大肘子"+i);
                        i++;
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            if (e.getMessage().equals("sleep interrupted")){
                                System.out.println("黑子阻止了  小白的  嗨吃之旅");
                                break;
                            }
                            e.printStackTrace();
                        }
                    } catch (Exception e) {

                        e.printStackTrace();
                    }
                }
            }
        });
        xiaoBai.start();
        Thread heizi=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    xiaoBai.interrupt();  //打断小白
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        heizi.start();
    }
}
