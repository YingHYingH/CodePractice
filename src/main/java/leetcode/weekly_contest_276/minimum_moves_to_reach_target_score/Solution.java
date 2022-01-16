package leetcode.weekly_contest_276.minimum_moves_to_reach_target_score;

public class Solution {
    public int minMoves(int target, int maxDoubles) {
        int count = 0;
        while (target != 1 && maxDoubles != 0) {
            count++;
            if ((target & 1) == 0) {
                maxDoubles--;
                target >>= 1;
            } else {
                target--;
            }
        }
        return count + target - 1;
    }

    public static void main(String[] args) {
        new Solution().minMoves(19, 2);
    }
}
