package revision.binarysearch;

public class FindNthRootOfNumber {
    public static void main(String[] args) {
        int M = 128, N = 7;
        int result = NthRoot(N, M);
        System.out.println("Find Nth root of a number " + result);
    }

    private static int NthRoot(int n, int m) {
        int start = 1;
        int end = m;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            long value = 1;
            boolean overflow = false;

            for (int i = 0; i < n; i++) {
                value *= mid;

                if (value > m) { // early break
                    overflow = true;
                    break;
                }
            }

            if (value == m) {
                return mid;
            } else if (value > m || overflow) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
