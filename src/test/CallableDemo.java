package test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class CallableTest implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "---你今天学休息了吗？");
        return "休息过了";
    }
}
/*class MyThread implements Runnable{

    @Override
    public void run() {

    }
}*/

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CallableTest callableTest = new CallableTest();
//        MyThread myThread = new MyThread();
//        Thread thread = new Thread(myThread);

        FutureTask futureTask = new FutureTask(callableTest);
        new Thread(futureTask , "AAA").start();

        System.out.println(Thread.currentThread().getName() + "\t 问你个事？");

        System.out.println(futureTask.get());
    }
}
