package revision.twopointers;

// For two lines Area

//Area = min(height[left], height[right]) * (right - left)

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = maxArea(height);
        System.out.println("Max Area is " + result);
    }

    // Brute Force approach

    private static int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){

                int area = Math.min(height[i], height[j]) * (j - i);

                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}
