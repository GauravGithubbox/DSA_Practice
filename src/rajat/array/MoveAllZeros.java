package rajat.array;

public class MoveAllZeros {
    public static void swap(int arr[], int a, int b) {
        int c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
    }

    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 3, 12};
        int n = arr.length;
        moveZeroes(arr);
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }
}
