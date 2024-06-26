package rajat.recursion.basic;

public class ReverseArray {
    // Function to reverse the array using recursion
    public static void reverseArray(int[] arr, int start, int end) {
        // Base case: If start is greater or equal to end, stop the recursion
        if (start >= end) {
            return;
        }

        // Swap the elements at start and end
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        // Recursive call to reverse the remaining sub-array
        reverseArray(arr, start + 1, end - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println("Original Array: ");
        printArray(arr);

        reverseArray(arr, 0, arr.length - 1);

        System.out.println("Reversed Array: ");
        printArray(arr);
    }

    // Helper function to print the array
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
