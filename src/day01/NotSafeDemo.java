package day01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class NotSafeDemo {
    public static void main(String[] args) {
        //ListNotSafe();
        Map<String , String> map = new ConcurrentHashMap<>();//new HashMap<>();

         for (int i = 1 ; i <= 30 ; i++){
                      new Thread(() -> {
                                 map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0 , 8));
                                 System.out.println(map);
                              } , String.valueOf(i)).start();
    }

/*    private static void ListNotSafe() {
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 1 ; i <= 30 ; i++){
             new Thread(() -> {
                         list.add(UUID.randomUUID().toString().replace("-" , "").substring(0 , 8));
                         System.out.println(list);
                     } , String.valueOf(i)).start();
        }*/
    }
}
