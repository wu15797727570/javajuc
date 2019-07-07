package day03;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriteLock  读写锁小练习
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        ReadWriteLockTest readWriteLockTest = new ReadWriteLockTest();
         for (int i = 1 ; i <= 5 ; i++) {
             final int tempInt = i;
              new Thread(() -> {
                  readWriteLockTest.write(tempInt + "" , tempInt);
              }, String.valueOf(i)).start();
          }

        for (int i = 1 ; i <= 5 ; i++) {
            final int tempInt = i;
            new Thread(() -> {
                readWriteLockTest.read(tempInt + "");
            }, String.valueOf(i)).start();
        }
    }
}

class ReadWriteLockTest{
   Map<String , Object> map = new HashMap();
   ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public void write(String key , Object value){
        readWriteLock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "------正在写入"  + key);
            TimeUnit.MILLISECONDS.sleep(300);
            map.put(key , value);
            System.out.println(Thread.currentThread().getName() + "------写入完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }

    }

    public void read(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "------正在读取");
            TimeUnit.MILLISECONDS.sleep(300);
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "------读取完成" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }

    }
}
