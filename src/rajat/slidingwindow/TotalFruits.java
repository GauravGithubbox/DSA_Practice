package rajat.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TotalFruits {
    public static int totalFruitsBruteForce(int N, int[] fruits) {
        int maxLen = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j = i; j < N; j++) {
                set.add(fruits[j]);
                if(set.size() <= 2) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
                else{
                    break;
                }
            }
        }
        return maxLen;
    }

    public static int totalFruitsSlidingWindow(int[] fruits) {
        int n = fruits.length;
        int maxLen = 0; // Initialize maxLen to 0 to track the maximum length of valid window
        int left = 0, right = 0;
        HashMap<Integer, Integer> fruitCount = new HashMap<>();

        // Iterate through the fruits array with the right pointer
        for (right = 0; right < n; right++) {
            // Add the current fruit to the basket (increase its count)
            fruitCount.put(fruits[right], fruitCount.getOrDefault(fruits[right], 0) + 1);

            // If we have more than 2 types of fruits in the basket, shrink the window from the left
            while (fruitCount.size() > 2) {
                int fruitsAtLeft = fruits[left];
                // Decrease the count of the fruit at the left pointer
                fruitCount.put(fruitsAtLeft, fruitCount.get(fruitsAtLeft) - 1);

                // If the count drops to zero, remove the fruit type from the map
                if (fruitCount.get(fruitsAtLeft) == 0) {
                    fruitCount.remove(fruitsAtLeft);
                }

                // Move the left pointer to the right to shrink the window
                left++;
            }

            // Update maxLen to the size of the current valid window
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen; // Return the maximum number of fruits we can pick
    }

    public static void main(String[] args) {
        int[] fruits1 = {2, 1, 2};
        System.out.println("Maximum fruits picked: " + totalFruitsSlidingWindow(fruits1)); // Output: 3

        int[] fruits2 = {1, 2, 3, 2, 2};
        System.out.println("Maximum fruits picked: " + totalFruitsSlidingWindow(fruits2)); // Output: 4

        int[] fruits3 = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println("Maximum fruits picked: " + totalFruitsSlidingWindow(fruits3)); // Output: 5
    }
}
