package day01;

import java.util.concurrent.TimeUnit;

/**
 * 1)	1 标准访问，请问先打印邮件还是短信？
 * 2)	2 邮件方法暂停4秒钟，请问先打印邮件还是短信？
 * 3)	3 新增一个普通方法hello()，请问先打印邮件还是hello？
 * 4)	4 两部手机，请问先打印邮件还是短信？
 * 5)	5 两个静态同步方法，同一部手机，请问先打印邮件还是短信？
 * 6)	6 两个静态同步方法，2部手机，请问先打印邮件还是短信？
 * 7)	7 1个普通同步方法,1个静态同步方法，1部手机，请问先打印邮件还是短信？
 * 8)	8 1个普通同步方法,1个静态同步方法，2部手机，请问先打印邮件还是短信？
 */


class Phone{
    public static synchronized void sendEmail(){

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----------sendEmail");
    }

    public synchronized void sendSMS(){
        System.out.println("----------sendSMS");
    }

/*    public void hello(){
        System.out.println("-----------hello");
    }*/
}


public class Loca8 {
    public static void main(String[] args) {

        Phone phone = new Phone();
        Phone phone1 = new Phone();
        new Thread(() -> {
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } , "phone1").start();

        new Thread(() -> {
            try {
                //phone.sendSMS();
                //phone.hello();
                phone1.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } , "phone1").start();
    }
}
