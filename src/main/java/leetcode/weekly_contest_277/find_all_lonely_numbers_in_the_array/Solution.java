package leetcode.weekly_contest_277.find_all_lonely_numbers_in_the_array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> res = new LinkedList<>();
        for (Integer k : map.keySet()) {
            if (!map.containsKey(k - 1) && !map.containsKey(k + 1) && map.get(k) == 1) {
                res.add(k);
            }
        }
        return res;
    }
}
