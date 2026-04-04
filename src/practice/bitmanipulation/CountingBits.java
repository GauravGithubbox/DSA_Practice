package practice.bitmanipulation;
// https://leetcode.com/problems/counting-bits/description/
public class CountingBits {
    public static void main(String[] args) {
        int n = 2;
        int [] result = countBits(n);
        System.out.println(result);
    }

    private static int[] countBits(int n) {
        int[] result = new int[n+1];
        for (int i = 0; i <= n; i++) {
            int count = 0;
            int temp = i;
            while (temp > 0) {
                count += temp & 1;
                temp = temp >> 1;
            }
            result[i] = count;

        }
        return result;
    }
}
