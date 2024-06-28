package rajat.recursion.basic;

public class SumOfDigit {
    public static int addDigit(int n) {
        if(n == 0) {
            return 0;
        }

        int smallOutput = addDigit(n/10);
        return n % 10 + smallOutput;
    }
    public static void main(String[] args) {
        System.out.println(addDigit(123));
    }
}
