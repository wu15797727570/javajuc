package test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    public static void main(String[] args) {
        //假设总共有三个厕所，6个人排队
        Semaphore semaphore = new Semaphore(3);

         for (int i = 1 ; i <= 6 ; i++) {
              new Thread(() -> {
                  try {
                      semaphore.acquire();
                      System.out.println(Thread.currentThread().getName() + "\t 进入厕所");
                      try {
                          TimeUnit.SECONDS.sleep(3);
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                      System.out.println(Thread.currentThread().getName() + "\t 离开厕所");
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }finally {

                      semaphore.release();
                      //返回信号量当前可用的许可数
                      System.out.println(semaphore.availablePermits());
                  }

              }, String.valueOf(i)).start();
          }
    }
}
