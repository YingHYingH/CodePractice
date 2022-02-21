package leetcode.weekly_contest_277.rearrange_array_elements_by_sign;

public class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] pos = new int[nums.length / 2];
        int[] neg = new int[nums.length / 2];
        int posIndex = 0;
        int negIndex = 0;
        for (int num : nums) {
            if (num < 0) {
                neg[negIndex++] = num;
            } else {
                pos[posIndex++] = num;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ((i & 1) == 0 ? pos[i / 2] : neg[i / 2]);
        }
        return nums;
    }
}
