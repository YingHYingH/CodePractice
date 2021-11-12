package leetcode.weekly_contest_255.find_unique_binary_string;

import java.util.Arrays;

public class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        int res = -1;
        String s = "";
        Arrays.sort(nums);
        for (int i = 0; i < Math.pow(2, n); i++) {
            res = i;
            for (String num : nums) {
                if (i == parseStr2Long(num)) {
                    res = -1;
                    break;
                }
            }
            if (res != -1) {
                s = Integer.toBinaryString(res);
                for (int j = s.length(); j < n; j++) {
                    s = "0" + s;
                }
                return s;
            }
        }
        return s;
    }

    public int parseStr2Long(String str) {
        int res = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            res += (chars[i] - '0') * Math.pow(2, chars.length - i - 1);
        }
        return res;
    }
}