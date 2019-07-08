package day06;

public class SingletonDemo {

    private static SingletonDemo instance = null;

    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName() + "我是构造方法SingletonDemo.......");
    }

    public static SingletonDemo getInstance(){
        if(null == instance) {
            synchronized (SingletonDemo.class)
            {
                if(null == instance){
                    instance = new SingletonDemo();
                }

            }

        }
        return instance;
    }

    public static void main(String[] args) {

        for (int i = 1 ; i <= 10 ; i++) {
              new Thread(() -> {
                  SingletonDemo.getInstance();
                 System.out.println("mysql001");
              }, String.valueOf(i)).start();
          }
    }
}
