/*Given an array A of positive integers. Your task is to find the leaders in the array. An element of the array is a leader if it is greater than all the elements to its right side or if it is equal to the maximum element on its right side. The rightmost element is always a leader.

Example 1:

Input:
n = 6
A[] = {16,17,4,3,5,2}
Output: 17 5 2
Explanation: The first leader is 17
as it is greater than all the elements
to its right.  Similarly, the next
leader is 5. The right most element
is always a leader so it is also
included.*/
package gaurav.array;

import java.util.ArrayList;
import java.util.Collections;

public class FindLeadersInArray {
    static ArrayList<Integer> leaders(int A[], int n) {
        ArrayList<Integer> leaders = new ArrayList<>();

        int maxFromRight = A[n - 1];  // The rightmost element is always a leader

        // Add the rightmost element as the first leader
        leaders.add(maxFromRight);

        // Traverse the array from the second last element to the first element
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] >= maxFromRight) {
                maxFromRight = A[i];
                leaders.add(maxFromRight);
            }
        }

        // The leaders were added in reverse order, so reverse the list before returning
        Collections.reverse(leaders);

        return leaders;
    }

    public static void main(String[] args) {
        int[] A = {16, 17, 4, 3, 5, 2};
        int n = A.length;

        ArrayList<Integer> result = leaders(A, n);

        System.out.println("Leaders in the array: " + result);
    }
}
