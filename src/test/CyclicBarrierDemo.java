package test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(6 , () -> {
            System.out.println("可以开始吃饭啦");
        });

         for (int i = 1 ; i <= 6 ; i++) {
              new Thread(() -> {
                  System.out.println(Thread.currentThread().getName() + "\t 到达餐厅就坐");
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
