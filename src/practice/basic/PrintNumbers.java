package gaurav.recursion.basic;
//https://www.geeksforgeeks.org/problems/print-1-to-n-without-using-loops3621/1
public class PrintNumbers {

    public static void main(String[] args) {
        PrintNumbers printer = new PrintNumbers();

        int number1 = 5;
        int number2 = 10;

        System.out.print("Numbers till " + number1 + ": ");
        printer.printTillN(number1);
        System.out.println();

        System.out.print("Numbers till " + number2 + ": ");
        printer.printTillN(number2);
        System.out.println();
    }

    static void printTillN(int N) {
        if (N == 1) {
            System.out.print(N + " ");
            return;
        }
        printTillN(N - 1);
        System.out.print(N + " ");
    }
}
