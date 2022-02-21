package leetcode.weekly_contest_277.count_elements_with_strictly_smaller_and_greater_elements;

public class Solution {
    public int countElements(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int minNum = 0;
        int maxNum = 0;
        for (int num : nums) {
            if (num > max) {
                maxNum = 1;
                max = num;
            } else if (num == max) {
                maxNum++;
            }
            if (num < min) {
                minNum = 1;
                min = num;
            } else if (num == min) {
                minNum++;
            }
        }
        return Math.max(nums.length - minNum - maxNum, 0);
    }
}