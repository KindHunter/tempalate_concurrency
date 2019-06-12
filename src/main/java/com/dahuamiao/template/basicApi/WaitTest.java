package com.dahuamiao.template.basicApi;


public class WaitTest {

    public static final Object lock = new Object();


    public static void main(String[] args){
        /**
         * 测试obj.wait()的使用，是否一定要获取obj的锁定
         */
        WaitThread thread1 = new WaitThread();
        thread1.run();
    }


    static class WaitThread extends Thread{

        static Object o = new Object();

        @Override
        public void run() {

            synchronized(lock){
                System.out.println("before wait");
                try {
                    /**
                     * 由于调用o.wait()方法的时候，没有获取o的锁定，只是获取到lock的锁定，
                     * 导致抛出了java.lang.IllegalMonitorStateException
                     */
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("after wait");
            }

        }

    }

}
