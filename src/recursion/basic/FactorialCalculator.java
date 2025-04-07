package gaurav.recursion.basic;
//https://www.geeksforgeeks.org/problems/factorial5739/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
public class  FactorialCalculator {

    public static void main(String[] args) {
        FactorialCalculator calculator = new FactorialCalculator();

        int number1 = 5;
        int number2 = 0;
        int number3 = 10;

        System.out.println("Factorial of " + number1 + " is " + calculator.factorial(number1));
        System.out.println("Factorial of " + number2 + " is " + calculator.factorial(number2));
        System.out.println("Factorial of " + number3 + " is " + calculator.factorial(number3));
    }

    static long factorial(int N) {
        if (N == 0) {
            return 1;
        }

        long fnm1 = factorial(N - 1);
        return N * fnm1;
    }
}

