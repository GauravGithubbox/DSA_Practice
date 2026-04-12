package revision.binarysearch;

public class FindSquareRootOfNumber {
    public static void main(String[] args) {
        int number = 28; // square root of this number is 5.292 so the floor value is 5 (will be the ans)
        int result = floorSqrt(number);
        System.out.println("Squre root of a number is " + result);
    }

    private static int floorSqrt(int number) {
        int start = 0;
        int end = number;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((long) mid * mid == number) {
                return mid;
            } else if ((long) mid * mid < number) {
                start = mid + 1;

            } else {
                end = mid - 1;
            }
        }
        return end;
    }
}
