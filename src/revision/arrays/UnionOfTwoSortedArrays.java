package revision.arrays;

import java.util.ArrayList;
import java.util.List;

public class UnionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1={1, 2, 3, 4, 5};
        int[] nums2={1, 2, 7};
        int [] result = unionArray(nums1,nums2);
        for(int n : result){
            System.out.println(n);
        }
    }

    private static int[] unionArray(int[] nums1, int[] nums2) {
        List<Integer> UnionList = new ArrayList<>();
        int i = 0, j = 0;
        int n = nums1.length;
        int m = nums2.length;

        while (i < n && j < m) {
            // Case 1 and 2
            if (nums1[i] <= nums2[j]) {
                if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums1[i]) {
                    UnionList.add(nums1[i]);
                }
                i++;
            }
            // Case 3
            else {
                if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums2[j]) {
                    UnionList.add(nums2[j]);
                }
                j++;
            }
        }

        // Add remaining elements of nums1, if any
        while (i < n) {
            if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums1[i]) {
                UnionList.add(nums1[i]);
            }
            i++;
        }

        // Add remaining elements of nums2, if any
        while (j < m) {
            if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums2[j]) {
                UnionList.add(nums2[j]);
            }
            j++;
        }

        // Convert List<Integer> to int[]
        int[] Union = new int[UnionList.size()];
        for (int k = 0; k < UnionList.size(); k++) {
            Union[k] = UnionList.get(k);
        }

        return Union;


    }
}
