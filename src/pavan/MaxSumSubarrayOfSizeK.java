package pavan;
import java.util.ArrayList;


public class MaxSumSubarrayOfSizeK {
    // The function to find the maximum sum subarray of size K
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
        long res = 0;
        for (int i = 0; i < K; i++)
            res += Arr.get(i);
        long curr_sum = res;
        for (int i = K; i < N; i++) {
            curr_sum += Arr.get(i) - Arr.get(i - K);
            res = Math.max(res, curr_sum);
        }
        return res;
    }

    // The main method to test the maximumSumSubarray function
    public static void main(String[] args) {
        ArrayList<Integer> Arr = new ArrayList<>();
        Arr.add(1);
        Arr.add(2);
        Arr.add(3);
        Arr.add(4);
        Arr.add(5);
        Arr.add(6);
        Arr.add(7);
        Arr.add(8);
        Arr.add(9);
        Arr.add(10);

        int K = 3;
        int N = Arr.size();

        long result = maximumSumSubarray(K, Arr, N);
        System.out.println("The maximum sum of a subarray of size " + K + " is: " + result);
    }
}
