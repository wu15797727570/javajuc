package day04;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(
                3 ,
                5 ,
                3L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()//DiscardOldestPolicy()//DiscardPolicy()//CallerRunsPolicy()//AbortPolicy()
        );

         for (int i = 1 ; i <= 9 ; i++) {
                  executorService.execute( () -> {
                      System.out.println(Thread.currentThread().getName() + "\t 正在办理");
                  });
          }
        executorService.shutdown();
    }
}
