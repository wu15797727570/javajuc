package day01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicket {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();
        new Thread(() -> { for(int i = 0 ; i < 31 ; i++) ticket.saleTicket();} , "AAA" ).start();
        new Thread(() -> { for(int i = 0 ; i < 31 ; i++) ticket.saleTicket();} , "BBB" ).start();
        new Thread(() -> { for(int i = 0 ; i < 31 ; i++) ticket.saleTicket();} , "CCC" ).start();

    
    }
}

class Ticket{

    private int nummber = 30;
    private int num = 1;
    private Lock lock = new ReentrantLock();

    public void saleTicket(){
        lock.lock();
        try {
            if(nummber > 0){
                System.out.println(Thread.currentThread().getName() +"当前卖出第" + (num++) + "张，\t 还剩" + (--nummber) + "张");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
         lock.unlock();
        }

    }
}


// new Thread(new Runnable() {
//@Override
//public void run() {
//        for(int i = 0 ; i < 101 ; i++) {
//        ticket.saleTicket();
//        }
//
//        }
//        } , "AAA").start();
//
//        new Thread(new Runnable() {
//@Override
//public void run() {
//        for(int i = 0 ; i < 101 ; i++) {
//        ticket.saleTicket();
//        }
//        }
//        } , "BBB").start();
//
//        new Thread(new Runnable() {
//@Override
//public void run() {
//        for(int i = 0 ; i < 101 ; i++) {
//        ticket.saleTicket();
//        }
//        }
//        } , "CCC").start();
