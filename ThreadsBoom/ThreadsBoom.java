package com.hp.XC.ThreadsBoom;

import java.util.Random;

public class ThreadsBoom {
    static int time=4;
    static int Password=new Random().nextInt(100000000);
    static   boolean boob=true;
    public static void main(String[] args) {

        final Thread  h1=new Thread(new Runnable() {
            public void run() {
                System.out.println("find boom");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
                while (time >=0) {
                    try {
                        if(time==0){
                            System.out.println("boom beng beng");
                            boob=false;
                            break;
                        }
                        time--;
                        System.out.println(time);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                       //������ʹ��interrupted Ҳ����ʹ��Stop()
                        // ����Stop��������ֹ��ǰ�߳����в���
                        // �ж��Ƿ�Ϊ˯�ߴ�ϲ��� ��������𵯳ɹ� �����������
                        if(e.getMessage().equals("sleep interrupted")){
                           System.out.println("success ");
                           break;
                       }
                       e.printStackTrace();
                    }
                }
            }
        });
        final Thread h2=new Thread(new Runnable() {
            public void run() {
                System.out.println("start chai boom ing");

                while(boob){
                    if (new Random().nextInt(100000000) ==Password) {
                        //������ interrupt()���
                        h1.interrupt();

                       //����һ ����ʱ��Ϊ����
                        // time=-1;
                        //System.out.println("�𵯳ɹ�");
                        break;
                    }
                }

            }
        });
        h1.start();
        try {
            Thread.sleep(800);
        }catch (InterruptedException e){
        }
        h2.start();
    }

}

