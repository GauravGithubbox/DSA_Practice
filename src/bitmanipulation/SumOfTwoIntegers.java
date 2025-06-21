package bitmanipulation;

public class SumOfTwoIntegers {
    public static void main(String[] args) {
        int a =1,b=2;
        int result = getSum(a,b);
        System.out.println("Result"+result);
    }

    private static int getSum(int a, int b) {
        while(b!=0){
            int tmp = (a&b)<<1;
            a = a ^b;
            b = tmp;
        }
        return a;
    }
}
