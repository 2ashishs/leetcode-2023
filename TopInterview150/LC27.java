/**
 * 27. Remove Element
 * Given an integer array nums and an integer val,
 * remove all occurrences of val in nums in-place.
 */
class LC27 {

    public int removeElement2(int[] nums, int val) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[idx++] = nums[i];
            }
        }
        return  idx;
    }

    public int removeElement1(int[] nums, int val) {
        //edge case
        if (nums.length == 0
                || (nums.length == 1 && nums[0] == val)) {
            return 0;
        }
        int t = nums.length - 1;
        int h = 0;
        while (t >= 0 && nums[t] == val) {
            t--;
        } //at the end of while loop, t will point to last non val element
        if (t == 0) {
            return 0;
        }
        while (h < t) {
            if (nums[h] == val) {
                nums[h++] = nums[t--];
                while (t >= h && nums[t] == val) {
                    t--;
                } //at the end of while loop, t will point to last non val element
            } else {
                h++;
            }
        }
        return t+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3};
        int val = 2;
        System.out.println(new LC27().removeElement1(nums, val));
        System.out.println(new LC27().removeElement2(nums, val));
    }
}
