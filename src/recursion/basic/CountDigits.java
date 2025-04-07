package gaurav.recursion.basic;
//https://www.geeksforgeeks.org/problems/count-digits5716/0
public class  CountDigits {


        public static void main(String[] args) {
            CountDigits counter = new CountDigits();

            int number1 = 1012;
            int number2 = 123456;
            int number3 = 120;
            int number4 = 111;
            int number5 = 0;

            System.out.println("Number of digits in " + number1 + " that evenly divide it: " + counter.countDivisibleDigits(number1));
            System.out.println("Number of digits in " + number2 + " that evenly divide it: " + counter.countDivisibleDigits(number2));
            System.out.println("Number of digits in " + number3 + " that evenly divide it: " + counter.countDivisibleDigits(number3));
            System.out.println("Number of digits in " + number4 + " that evenly divide it: " + counter.countDivisibleDigits(number4));
            System.out.println("Number of digits in " + number5 + " that evenly divide it: " + counter.countDivisibleDigits(number5));
        }

        public int countDivisibleDigits(int N) {
            return countDivisibleDigitsRecursive(N, N);
        }

        // Recursive method to count digits that evenly divide the original number
        private static int countDivisibleDigitsRecursive(int n, int original) {
            // Base case: if n is reduced to 0, stop the recursion
            if (n == 0) {
                return 0;
            }

            // Get the last digit of n
            int lastDigit = n % 10;

            // Recur for the remaining digits of n
            int count = countDivisibleDigitsRecursive(n / 10, original);

            // Check if the last digit divides the original number evenly
            if (lastDigit != 0 && original % lastDigit == 0) {
                return count + 1;
            }

            return count;
        }


}
