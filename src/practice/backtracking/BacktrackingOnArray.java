package practice.backtracking;


public class BacktrackingOnArray {
    public static void changeArray(int[] arr, int i, int val) {
        if (i == arr.length) {
            printArray(arr);
            return;
        }
        arr[i] = val;
        changeArray(arr, i + 1, val + 1); // [1,2,3,4,5]
        arr[i] = arr[i] - 2;  // actually this is the practice.backtracking step
        // After calculating the practice.recursion we move to the practice.backtracking step and calculate the
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = new int[5];
        changeArray(arr, 0, 1);
        printArray(arr);
    }

}
