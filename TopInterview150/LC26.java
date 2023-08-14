/**
 * 26. Remove Duplicates from Sorted Array
 * Given an integer array nums sorted in non-decreasing order,
 * remove the duplicates in-place
 * such that each unique element appears only once.
 * Then return the number of unique elements in nums
 */
public class LC26 {

    public int removeDuplicates(int[] nums) {
        // edge case
        if (nums.length <= 1) return nums.length;
        // maintain an idx of unique elements
        int idx = 1;
        // scan the array & if nums[i] != nums[idx], set nums[idx]=nums[i] and idx++
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[idx-1]) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        System.out.println(new LC26().removeDuplicates(nums));
    }
}
