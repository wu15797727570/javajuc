package test;

import java.util.concurrent.TimeUnit;

class MyThread{
    volatile int number = 0;

    public void change(){
        this.number = 60;
    }
}

public class VolatileDemo {

    /**
     * 验证volatile的可见性
     */
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

          new Thread(new Runnable() {
                     @Override
                     public void run() {
                         System.out.println(Thread.currentThread().getName() + "\t 线程运行前 number值=" + myThread.number);
                         myThread.change();
                         try {
                             TimeUnit.SECONDS.sleep(3);
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                         System.out.println(Thread.currentThread().getName() + "\t 线程运行后 number值=" + myThread.number);
                     }
                 } , "AAA").start();

          while(myThread.number == 0){
              //如果number等于0，一直循环，如果不为0，打印下面的输出语句
          }

        System.out.println(Thread.currentThread().getName() + "主线程获取更改后的number值 = " + myThread.number);
    }

}
