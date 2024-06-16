package rajat.binarysearch.practice;

// https://leetcode.com/problems/minimum-speed-to-arrive-on-time/
public class MinimumSpeedToArriveOnTime {
    public static boolean isFeasible(int[] dist, double hour, int speed) {
        double totalTime = 0.0;

        for (int i = 0; i < dist.length; i++) {
            if (i != dist.length - 1) {
                // For all but the last segment, we round up to the nearest whole number
                totalTime += Math.ceil((double) dist[i] / speed);
            } else {
                // For the last segment, we take the exact time
                totalTime += (double) dist[i] / speed;
            }
        }
        return totalTime <= hour;

    }
    public static int minSpeedOnTime(int[] dist, double hour) {
        if(hour < dist.length-1) return -1;
        int low = 0;
        int high = 10000000;
        int ans = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(isFeasible(dist, hour, mid)) {
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] dist = {1, 3, 2};
        double hours = 2.7;

        System.out.println(minSpeedOnTime(dist, hours));

    }
}
