package leetcode.weekly_contest_275.minimum_swaps_to_group_all_1s_together_ii;

public class Solution {
    public int minSwaps(int[] nums) {
        int len = 0;
        for (int num : nums) {
            if (num == 1) {
                len++;
            }
        }
        int[] newNums = new int[len + nums.length - 1];
        for (int i = 0; i < newNums.length; i++) {
            newNums[i] = nums[i % nums.length];
        }
        int res = Integer.MAX_VALUE;
        int min = 0;
        for (int i = 0; i < len; i++) {
            if (newNums[i] == 0) {
                min++;
            }
        }
        res = min;
        for (int i = 1; i < nums.length; i++) {
            if (newNums[i - 1] == 0) {
                min--;
            }
            if (newNums[i + len-1] == 0) {
                min++;
            }
            res = Math.min(res, min);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,1,1,0,0};
        new Solution().minSwaps(arr);
    }
}
