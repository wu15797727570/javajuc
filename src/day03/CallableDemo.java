package day03;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class CallableTest implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {

        System.out.println("********come in test");
       /* try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return 1024;
    }
}


public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask futureTask = new FutureTask(new CallableTest());

        new Thread(futureTask , "AAA").start();
        new Thread(futureTask , "BBB").start();

        System.out.println("-------------CallableDemo");

        System.out.println(futureTask.get());
    }
}
