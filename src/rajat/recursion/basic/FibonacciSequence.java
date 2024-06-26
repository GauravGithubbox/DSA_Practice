package rajat.recursion.basic;
import java.util.ArrayList;
public class FibonacciSequence {
    public static void fn(int n,  int []ls, int i ){
       if(i < n) {
           if (i == 0) {
               ls[i] = 0;
           } else if (i == 1) ls[i] = 1;
           else {
               ls[i] = ls[i - 1] + ls[i - 2];
           }
           fn(n, ls, i + 1);
       }
    }
    public static int[] generateFibonacciNumbers(int n) {
        // Write your code here.
        ArrayList<Integer> e = new ArrayList<Integer>();
        int ls[] = new int[n];
        fn(n, ls, 0);
        return ls;
    }
    public static void main(String[] args) {
        int[] ans = generateFibonacciNumbers(5);
        for(int ele : ans) System.out.print(ele + " ");
    }
}



