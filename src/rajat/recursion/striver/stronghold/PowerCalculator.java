package rajat.recursion.striver.stronghold;
//https://leetcode.com/problems/powx-n/description/
public class PowerCalculator {
    public double myPowHelper(double x, long n) {
        if (n == 0) {
            return 1.0;  // Base case: x^0 = 1
        }

        double half = myPowHelper(x, n / 2);

        if (n % 2 == 0) {
            return half * half;  // If n is even, x^n = (x^(n/2))^2
        } else {
            return half * half * x;  // If n is odd, x^n = (x^(n/2))^2 * x
        }
    }

    // Public method to handle negative exponents and edge cases
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;  // Any number to the power of 0 is 1
        }

        long N = n;  // Convert n to long to handle overflow for -n
        if (N < 0) {
            x = 1 / x;  // If n is negative, compute 1/x and use -n
            N = -N;
        }

        return myPowHelper(x, N);
    }

    public static void main(String[] args) {
        PowerCalculator solution = new PowerCalculator();

        // Test cases
        System.out.println(solution.myPow(2.0, 10));  // Output: 1024.0
        System.out.println(solution.myPow(2.1, 3));   // Output: 9.261
        System.out.println(solution.myPow(2.0, -2));  // Output: 0.25
        System.out.println(solution.myPow(2.0, 0));   // Output: 1.0
        System.out.println(solution.myPow(2.0, Integer.MIN_VALUE)); // Output: 0.0 (or a very small number close to zero)
    }
}
