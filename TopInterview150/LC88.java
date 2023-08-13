/**
 * 88. Merge Sorted Array
 * Given two integer arrays nums1 (of length m+n) and nums2 (of length n),
 * sorted in non-decreasing order, and two integers m and n:
 * Merge nums1 and nums2 into a single array (inside the array nums1),
 * sorted in non-decreasing order.
 */
class LC88 {

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        // set pointers to tail of both arrays - t1, t2
        int t1 = m - 1;
        int t2 = n - 1;
        // set pointer t3 to end of nums1
        int t3 = m + n - 1;
        // while (terminating condition)
        while (t1 >= 0 && t2 >= 0) {
            // nums1[t3] = if nums1[t1] >= nums2[t2]: nums1[t1--] else: nums2[t2--]
            if (nums1[t1] >= nums2[t2]) {
                nums1[t3--] = nums1[t1--];
            } else {
                nums1[t3--] = nums2[t2--];
            }
        }
        // if (terminating condition) copy remainder array if reqd
        if (t1 < 0) {
            for (int i = t2; i >= 0; i--) {
                nums1[t3--] = nums2[t2--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;
        new LC88().merge1(nums1, m, nums2, n);
        for (int j : nums1) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
