package test;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(6);

         for (int i = 1 ; i <= 6 ; i++) {
              new Thread(() -> {
                  System.out.println(Thread.currentThread().getName() + "离开了教室");
                  countDownLatch.countDown();
              }, String.valueOf(i)).start();
          }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("班长最后关门");
    }
}
