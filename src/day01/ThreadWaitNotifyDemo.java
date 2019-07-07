package day01;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadWaitNotifyDemo {
    /**
     *
     *  @auther zzyy
     *  @create 2019-02-19 8:44
     *   题目：现在两个线程，可以操作初始值为零的一个变量，
     *  实现一个线程对该变量加1，一个线程对该变量减1，
     *  实现交替，来10轮，变量初始值为零。
     */
    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();

           new Thread(() -> {
               for (int i = 1 ; i <= 10 ; i++){
                   try {
                       airConditioner.add();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
                   } , "AAA").start();
        new Thread(() -> {
            for (int i = 1 ; i <= 10 ; i++){
                try {
                    airConditioner.sub();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } , "BBB").start();
        new Thread(() -> {
            for (int i = 1 ; i <= 10 ; i++){
                try {
                    airConditioner.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } , "CCC").start();
        new Thread(() -> {
            for (int i = 1 ; i <= 10 ; i++){
                try {
                    airConditioner.sub();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } , "DDD").start();




    }
}

class AirConditioner {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();


    public void add() throws InterruptedException {

        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void sub() throws InterruptedException {

        lock.lock();
        try {
           while (number == 0) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}



