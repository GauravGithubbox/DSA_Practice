package rajat.recursion.basic;

public class Factorial {
    public static int factorial(int n){
        if(n == 0){
            return 1;
        }

        int smallOutput = factorial(n - 1);
        return n * smallOutput;
    }
    public static void main(String[] args){
        int fact = factorial(5);
        System.out.println(fact);
    }
}
