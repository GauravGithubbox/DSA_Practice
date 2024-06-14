package rajat.binarysearch.striversheet.binarysearchonanswers;

public class FindNthRoot {
    public static int verifyMidRaisedToNthPower(int mid, int n, int m) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;
            if (ans > m) return 2;
        }
        if (ans == m) return 1;
        return 0;
    }

    public static int NthRoot(int n, int m) {
        int low = 1, high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midN = verifyMidRaisedToNthPower(mid, n, m);
            if (midN == 1) {
                return mid;
            } else if (midN == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n1 = 3;
        int m1 = 27;
        System.out.println("The " + n1 + "rd root of " + m1 + " is: " + NthRoot(n1, m1));

        int n2 = 2;
        int m2 = 16;
        System.out.println("The " + n2 + "nd root of " + m2 + " is: " + NthRoot(n2, m2));

        int n3 = 4;
        int m3 = 17;
        System.out.println("The " + n3 + "th root of " + m3 + " is: " + NthRoot(n3, m3));
    }
}
