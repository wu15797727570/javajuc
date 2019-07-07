package day04;


import java.util.concurrent.RecursiveTask;

class MyFrokJoin extends RecursiveTask<Integer> {
    private static final Integer NUMBER_NU = 10;
    private Integer start;
    private Integer end;
    private Integer result;

    public MyFrokJoin(Integer start , Integer end){
        this.start = start ;
        this.end = end ;
    }

    @Override
    protected Integer compute() {

        if((end - start) <= NUMBER_NU){
            for(int i = start ; i <=start ; i++){
                result = result + i;
            }
        }else{
            int a = (start + end) / 2;

        }



        return result;
    }
}


public class ForkJoinDemo {
    public static void main(String[] args) {

    }
}
