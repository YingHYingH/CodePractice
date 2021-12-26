package leetcode.weekly_contest_273.recover_the_original_array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[nums.length / 2];
        for (int i = 1; i <= nums.length / 2; i++) {
            if (nums[i] == nums[0]) {
                continue;
            }
            int dif = nums[i] - nums[0];
            if (dif % 2 != 0) {
                continue;
            }
            int point = 0;
            Queue<Integer> q = new LinkedList<Integer>();
            for (int j = 0; j < nums.length; j++) {
                if (!q.isEmpty() && q.peek() == nums[j]) {
                    q.poll();
                    continue;
                }
                if (point == nums.length / 2) {
                    break;
                }
                q.offer(nums[j] + dif);
                res[point++] = nums[j] + dif / 2;
            }
            if (q.isEmpty()) {
                break;
            }
        }
        return res;
    }
}
