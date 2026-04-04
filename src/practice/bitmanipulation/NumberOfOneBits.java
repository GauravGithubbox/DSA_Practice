package practice.bitmanipulation;
//https://leetcode.com/problems/number-of-1-bits/description/
public class NumberOfOneBits {
    public static void main(String[] args) {
        int n =11;
        int result = findHammingWeight(n);
        System.out.println("Hamming Weight is =>"+result);
    }

    private static int findHammingWeight(int n) {
        int result = 0;
        while (n > 0) {
            result += n & 1;
            n = n >> 1;

        }
        return result;
    }
}
