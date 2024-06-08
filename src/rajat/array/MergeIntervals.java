package rajat.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
//https://leetcode.com/problems/merge-intervals/
public class MergeIntervals {

    /**
     * Merges overlapping intervals.
     * This method checks each interval and merges if there are overlaps.
     * Time Complexity: O(n log n) for sorting, O(n^2) for merging in the worst case.
     * Space Complexity: O(n) for storing the output.
     *
     * @param intervals A 2D array where each sub-array represents an interval.
     * @return A 2D array of merged intervals.
     */
    public static int[][] mergeIntervals(int[][] intervals) {
        int n = intervals.length;

        // Sort the intervals based on their start times
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // List to hold merged intervals
        List<List<Integer>> merged = new ArrayList<>();

        // Traverse through each interval
        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            // Skip the current interval if it is completely within the last merged interval
            if (!merged.isEmpty() && end <= merged.get(merged.size() - 1).get(1)) {
                continue;
            }

            // Merge overlapping intervals
            for (int j = i + 1; j < n; j++) {
                if (end >= intervals[j][0]) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }

            // Add the merged interval to the list
            merged.add(Arrays.asList(start, end));
        }

        // Convert the list of merged intervals to a 2D array
        int[][] result = new int[merged.size()][2];
        int k = 0;
        for (List<Integer> interval : merged) {
            result[k][0] = interval.get(0);
            result[k][1] = interval.get(1);
            k++;
        }

        return result;
    }

    /**
     * Optimized method to merge overlapping intervals.
     * This method uses a more efficient approach by maintaining and updating only the last interval in the merged list.
     * Time Complexity: O(n log n) for sorting, O(n) for merging.
     * Space Complexity: O(n) for storing the output.
     *
     * @param intervals A 2D array where each sub-array represents an interval.
     * @return A 2D array of merged intervals.
     */
    public static int[][] mergeIntervalsOptimal(int[][] intervals) {
        int n = intervals.length;

        // Sort the intervals based on their start times
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // List to hold merged intervals
        List<List<Integer>> output = new ArrayList<>();

        // Traverse through each interval
        for (int i = 0; i < n; i++) {
            // If the list is empty or there's no overlap, add the interval to the list
            if (output.isEmpty() || output.get(output.size() - 1).get(1) < intervals[i][0]) {
                output.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            } else {
                // If there's an overlap, merge the current interval with the last one in the list
                output.get(output.size() - 1).set(1, Math.max(output.get(output.size() - 1).get(1), intervals[i][1]));
            }
        }

        // Convert the list of merged intervals to a 2D array
        int[][] result = new int[output.size()][2];
        int k = 0;
        for (List<Integer> interval : output) {
            result[k][0] = interval.get(0);
            result[k][1] = interval.get(1);
            k++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 9}, {8, 10}, {2, 4}, {15, 18}, {16, 17}};

        // Print input intervals
        System.out.println("Input Intervals: ");
        Arrays.stream(intervals)
                .forEach(subInterval -> {
                    Arrays.stream(subInterval).forEach(ele -> System.out.print(ele + " "));
                    System.out.println(); // Print a new line for each interval
                });

        // Merge the intervals using the optimal method
        System.out.println("Merged Intervals: ");
        int[][] result = mergeIntervalsOptimal(intervals);

        // Print merged intervals
        for (int[] pairs : result) {
            for (int ele : pairs) {
                System.out.print(ele + " ");
            }
            System.out.println(); // Print a new line for each merged interval
        }
    }
}
