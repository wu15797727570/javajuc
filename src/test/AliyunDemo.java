package test;

public class AliyunDemo {
    public static void main(String[] args) {
       /* int sum = 0;
        int x = 10;
        while(x > 0){
            sum += x;
        }
        System.out.println(sum);*/

      /* int x =10;
       double y = 20.2;
       long z = 10L;
       String str = "" +x+y*z;
        System.out.println(str);*/

      /*int num = 2147483647;
       long temp = num + 2L;
        System.out.println(num);*/

     /* int num = 50;
      num = num++ * 2;
        System.out.println(num);*/

     int i = 1;
     int j = i++;
     if((i == (++j)) && ((i++) == j)){
         i += j;
     }
        System.out.println(i);
    }
}
