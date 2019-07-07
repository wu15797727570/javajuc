package day03;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class BlockingQueueDemo {
    public static void main(String[] args) {
        ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<>(3);
/*        System.out.println(queue.add("a"));
        System.out.println(queue.add("c"));
        System.out.println(queue.add("b"));
       // System.out.println(queue.add("a"));

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        //System.out.println(queue.remove());*/


/*        System.out.println(queue.offer("a"));
        System.out.println(queue.offer("b"));
        System.out.println(queue.offer("c"));
        //System.out.println(queue.offer("d"));

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        //System.out.println(queue.poll());*/

        ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();
        new HashMap();
    }
}
