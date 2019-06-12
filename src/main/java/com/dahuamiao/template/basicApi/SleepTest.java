package com.dahuamiao.template.basicApi;

public class SleepTest {


    public static void main(String[] args){
        SleepThread sleepThread = new SleepThread();
        sleepThread.start();
        try {
            /**
             * 事实证明，sleep()方法的使用和调用者没有关系，只要使用的sleep()方法，当前线程就会暂停
             * 所以sleep()的推荐使用方法是Thread.sleep()
             */
            sleepThread.sleep(100000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end!");
    }




    static class SleepThread extends Thread{

        @Override
        public void run() {
            for (int i=0;;++i){

                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
