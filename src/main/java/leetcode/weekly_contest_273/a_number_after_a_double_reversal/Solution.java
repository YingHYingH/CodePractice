package leetcode.weekly_contest_273.a_number_after_a_double_reversal;

public class Solution {
    public boolean isSameAfterReversals(int num) {
        int a = num % 10;
        int res = 0;
        while (a != 0 || num != 0) {
            res += 10 * res + a;
            num = num / 10;
            a = num % 10;
        }
        return res == num;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isSameAfterReversals(526));
        System.out.println(new Solution().isSameAfterReversals(1800));
        System.out.println(new Solution().isSameAfterReversals(0));
    }
}
