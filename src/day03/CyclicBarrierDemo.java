package day03;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, new Runnable() {
            @Override
            public void run() {
                System.out.println("召唤七龙珠");
            }
        });

         for (int i = 1 ; i <= 7 ; i++) {
             int tempInt = i;

             new Thread(() -> {
                 System.out.println(Thread.currentThread().getName() + "收集到第" + tempInt + "颗龙珠");
                 try {
                     cyclicBarrier.await();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 } catch (BrokenBarrierException e) {
                     e.printStackTrace();
                 }

             }, String.valueOf(i)).start();

         }

    }
}
