package twopointers;
//https://leetcode.com/problems/move-zeroes/

public class RotedZeroToRight {
    public static void main(String[] args) {
        int[] arr ={1,0,2,0,3,0,4};
        System.out.println();
        int[] ints = sendZeroToRightSide(arr);
        for(int in : ints){
            System.out.println("data -->"+in);
        }
    }

    private static int[]  sendZeroToRightSide(int[] arr) {
        int i = 0; // slow pointer

        // Move non-zero elements to the front
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != 0) {
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        return arr;
    }

}
