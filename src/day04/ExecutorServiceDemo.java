package day04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {
    public static void main(String[] args) {
         MyThread myThread = new MyThread();
        //ExecutorService executorService = Executors.newFixedThreadPool(3);
        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 1 ; i <= 10 ; i++) {
             try {
                 TimeUnit.MILLISECONDS.sleep(300);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             executorService.execute(myThread);
          }
          executorService.shutdown();
    }
}



class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "\t 正在办理");
    }
}
