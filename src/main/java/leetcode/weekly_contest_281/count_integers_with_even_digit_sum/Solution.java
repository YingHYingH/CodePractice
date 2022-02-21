package leetcode.weekly_contest_281.count_integers_with_even_digit_sum;

public class Solution {
    public int countEven(int num) {
        int res = 0;
        for (int i = 1; i <= num; i++) {
            if (isEven(i)) {
                res++;
            }
        }
        return res;
    }

    public boolean isEven(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return (res & 1) == 0;
    }
}
