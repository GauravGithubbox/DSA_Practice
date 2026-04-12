package revision.binarysearch;

public class FloorAndCeilInSortedArray {
    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8, 10, 12, 14};
        int x = 1;
        int[] result = findFloorCeil(nums, x);
        System.out.println("floor " + result[0]);
        System.out.println("floor " + result[1]);

    }

    private static int[] findFloorCeil(int[] nums, int x) {
        int left = 0;
        int right = nums.length - 1;
        int floor = -1;
        int ceil = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == x) {
                floor = nums[mid];
                ceil = nums[mid];
                break;

            } else if (nums[mid] < x) {
                floor = nums[mid];   // left always have the small value
                left = mid + 1;
            } else {
                ceil = nums[mid];
                right = mid - 1;  // right always have the small value
            }
        }
        return new int[]{floor, ceil};
    }
}
