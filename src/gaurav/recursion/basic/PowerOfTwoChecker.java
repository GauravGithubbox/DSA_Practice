package gaurav.recursion.basic;
//https://leetcode.com/problems/power-of-two/description/
public class PowerOfTwoChecker {

    public static void main(String[] args) {
        PowerOfTwoChecker checker = new PowerOfTwoChecker();

        int number1 = 1;
        int number2 = 16;
        int number3 = 18;
        int number4 = 64;
        int number5 = 0;

        System.out.println("Is " + number1 + " a power of two? " + checker.isPowerOfTwo(number1));
        System.out.println("Is " + number2 + " a power of two? " + checker.isPowerOfTwo(number2));
        System.out.println("Is " + number3 + " a power of two? " + checker.isPowerOfTwo(number3));
        System.out.println("Is " + number4 + " a power of two? " + checker.isPowerOfTwo(number4));
        System.out.println("Is " + number5 + " a power of two? " + checker.isPowerOfTwo(number5));
    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 != 0) {
            return false;
        }
        return isPowerOfTwo(n / 2);
    }
}

