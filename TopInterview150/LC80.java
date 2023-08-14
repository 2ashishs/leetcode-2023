/**
 * 80. Remove Duplicates from Sorted Array II
 * Given an integer array nums sorted in non-decreasing order,
 * remove some duplicates in-place such that
 * each unique element appears at most twice.
 * Return k after placing the final result in the first k slots of nums.
 */
public class LC80 {

    public int removeDuplicates(int[] nums) {
        // edge case: nums.length <= 2
        if (nums.length <= 2) return nums.length;
        // init idx to track unique elements at most twice
        int idx = 2;
        // scan the array & update idx
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > nums[idx-1] || nums[i] > nums[idx-2]) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(new LC80().removeDuplicates(nums));
    }
}
