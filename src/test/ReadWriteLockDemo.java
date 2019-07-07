package test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        ReadWriteTest readWriteTest = new ReadWriteTest();

         for (int i = 1 ; i <= 5 ; i++) {
             final int tempInt = i;

              new Thread(() -> {
                  readWriteTest.write(tempInt + "" , UUID.randomUUID().toString().substring(0 , 3));
              }, String.valueOf(i)).start();
          }

          for (int i = 1 ; i <= 5 ; i++) {
              final int tempInt = i;

              new Thread(() -> {
                  try {
                      TimeUnit.SECONDS.sleep(1);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                   readWriteTest.read(tempInt + "");
               }, String.valueOf(i)).start();
           }
    }
}

class ReadWriteTest{
    Map<String , String> map = new HashMap<>();
     ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void write(String key , String value){

       readWriteLock.writeLock().lock();
          try {
              System.out.println(Thread.currentThread().getName() + " \t -----------正在写入数据" + key);
              map.put(key , value);
              System.out.println(Thread.currentThread().getName() + "\t -----------写入完成" );
                  } catch (Exception e) {
                      e.printStackTrace();
                  }finally {
                      readWriteLock.writeLock().unlock();
                  }

    }

    public void read(String key){
        readWriteLock.readLock().lock();
          try {
              System.out.println(Thread.currentThread().getName() + "\t -----------正在读取数据");

              Object re = map.get(key);
              System.out.println(Thread.currentThread().getName() + "\t -----------读取完成" + re);
                  } catch (Exception e) {
                      e.printStackTrace();
                  }finally {
                      readWriteLock.readLock().unlock();
                  }

    }

}
