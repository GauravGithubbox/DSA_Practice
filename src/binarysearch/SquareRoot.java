package binarysearch;

public class SquareRoot {
    public static void main(String[] args) {
        int x = 8;
        int result = mySqrt(x);
        System.out.println("result =>"+result);
    }

    private static int mySqrt(int x) {
        if (x < 2) return x;

        int low = 1, high = x, ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((long) mid * mid == x) {
                return mid;
            } else if ((long) mid * mid < x) {
                ans = mid;  // potential answer
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
