package rajat.binarysearch.striversheet.onedimensional;

public class FirstAndLastOccurrence {
    public static int lowerBound(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int result = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                result = mid;
                end = mid - 1;
            }
            else if(nums[mid] < target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return result;
    }
    public static int upperBound(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int upper_bound = -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                upper_bound = mid;
                start = mid + 1;
            }
            else if(nums[mid] < target) {
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return upper_bound;
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = lowerBound(nums, target);
        result[1] = upperBound(nums, target);
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        int[] output = searchRange(nums, target);
        System.out.println(output[0] + " " + output[1]);

    }
}
