package leetcode.weekly_contest_255.find_greatest_common_divisor_of_array;

import java.util.Arrays;

public class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length - 1];
        if (min == max) {
            return min;
        } else {
            return getGCDOfTwo(min, max);
        }
    }

    public int getGCDOfTwo(int a, int b) {
        int res = 1;
        for (int i = 2; i <= a; i++) {
            if (a % i == 0 && b % i == 0) {
                res = i;
            }
        }
        return res;
    }
}