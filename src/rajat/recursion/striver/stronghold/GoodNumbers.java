package rajat.recursion.striver.stronghold;

//https://leetcode.com/problems/count-good-numbers/
public class GoodNumbers {
    private static final long MOD = 1000000007;
    public static long myPowHelper(long x, long n) {
        if (n == 0) {
            return 1;  // Base case: x^0 = 1
        }

        long half = myPowHelper(x, n / 2);

        if (n % 2 == 0) {
            return ((half % MOD) * (half % MOD)) % MOD;  // If n is even, x^n = (x^(n/2))^2
        } else {
            return ((half % MOD) * (half % MOD) * x) % MOD;  // If n is odd, x^n = (x^(n/2))^2 * x
        }
    }
    public static int countGoodNumbers(long n) {
        // Calculate number of positions for even and odd indices
        long evenCount = (n + 1) / 2;  // ceil(n/2)
        long oddCount = n / 2;         // floor(n/2)

        // Number of choices for even positions (0, 2, 4, 6, 8) = 5
        // Number of choices for odd positions (2, 3, 5, 7) = 4
        long evenChoices = 5;
        long oddChoices = 4;

        // Compute the total number of good numbers
        long evenResult = myPowHelper(evenChoices, evenCount);
        long oddResult = myPowHelper(oddChoices, oddCount);

        // Multiply the results and take modulo
        long result = (evenResult * oddResult) % MOD;

        return (int) result;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(countGoodNumbers(1));   // Output: 5
        System.out.println(countGoodNumbers(4));   // Output: 400
        System.out.println(countGoodNumbers(50));  // Output: 564908303
        System.out.println(countGoodNumbers(1000));// Output: 205831327
    }
}
