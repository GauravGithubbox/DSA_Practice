package revision.recursion;


public class Pow_x_And_n {
    public static void main(String[] args) {
        double x = 2.0000;
        int n = 10;
        double result = myPow(x, n);
        System.out.println("Pow " + result);
    }

    private static double power(double x, int n) {
        // Base case: x^0 = 1
        if (n == 0) {
            return 1.0;
        }

        // Recursive case: Compute x^(n/2)
        double half = power(x, n / 2);

        // If n is even, result is half * half
        if (n % 2 == 0) {
            return half * half;
        } else {
            // If n is odd, result is x * half * half
            return x * half * half;
        }
    }

    public static double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return power(x, n);
    }
}
