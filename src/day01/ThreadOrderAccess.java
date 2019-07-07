package day01;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareResource{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void print5() throws InterruptedException {
        //判断
        lock.lock();
        try {
            while(number != 1){
                condition1.await();
            }
            //干活
            for (int i = 1 ; i <= 5 ; i++){
                System.out.println(Thread.currentThread().getName() + "\t" + "AAA");
            }

            //通知
            number = 2;
            condition1.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print10() throws InterruptedException{
        //判断
        lock.lock();
        try {
            while(number != 2){
                condition1.await();
            }
            //干活
            for (int i = 1 ; i <= 10 ; i++){
                System.out.println(Thread.currentThread().getName() + "\t" + "BBB");
            }

            //通知
            number = 3;
            condition1.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print15() throws InterruptedException{
        //判断
        lock.lock();
        try {
            while(number != 3){
                condition1.await();
            }
            //干活
            for (int i = 1 ; i <= 15 ; i++){
                System.out.println(Thread.currentThread().getName() + "\t" + "CCC");
            }

            //通知
            number = 1;
            condition1.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}


public class ThreadOrderAccess {



    /**
     *  * 多线程之间按顺序调用，实现A->B->C
     *  * 三个线程启动，要求如下：
     *  *
     *  * AA打印5次，BB打印10次，CC打印15次
     *  * 接着
     *  * AA打印5次，BB打印10次，CC打印15次
     *  * ......来10
     */
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();

         new Thread(() -> {
                     for(int i = 1 ; i <= 10 ; i++){
                         try {
                             shareResource.print5();
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                     }
                 } , "线程一").start();

        new Thread(() -> {
            for(int i = 1 ; i <= 10 ; i++){
                try {
                    shareResource.print10();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } , "线程二").start();

        new Thread(() -> {
            for(int i = 1 ; i <= 10 ; i++){
                try {
                    shareResource.print15();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } , "线程三").start();
    }
}
