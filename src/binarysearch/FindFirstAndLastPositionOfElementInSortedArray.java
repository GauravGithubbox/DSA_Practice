package binarysearch;

class FindFirstAndLastPositionOfElementInSortedArray {
    public int findStartingIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int startPos = -1;
        int endPos = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                startPos = mid;
                end = mid - 1; // first occurance
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return startPos;
    }

    public int findEndingIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        int endPos = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                endPos = mid;
                start = mid + 1; // last occurance
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return endPos;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findStartingIndex(nums, target);
        result[1] = findEndingIndex(nums, target);
        return result;

    }
}
