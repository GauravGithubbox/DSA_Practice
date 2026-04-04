package revision.arrays;

import java.util.ArrayList;
import java.util.List;

public class IntersectionTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 3, 5};
        int[] nums2 = {1, 2, 7};
        int[] result = interSectionArray(nums1, nums2);
        for (int fu : result) {
            System.out.println(fu);
        }

    }

    private static int[] interSectionArray(int[] nums1, int[] nums2) {
        List<Integer> interSection = new ArrayList<>();
        int i = 0;
        int j = 0;
        int n = nums1.length;
        int m = nums2.length;
        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums2[j] < nums1[i]) {
                j++;
            }
            //nums1[i]== nums2[j]
            else {
                interSection.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[interSection.size()];
        for (int k = 0; k < interSection.size(); k++) {
            result[k] = interSection.get(k);
        }
        return result;

    }
}
