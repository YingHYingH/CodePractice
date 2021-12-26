package leetcode.weekly_contest_273.intervals_between_identical_elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public long[] getDistances(int[] arr) {
        long[] res = new long[arr.length];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }
        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            int index0 = list.get(0);
            long sum0 = 0;
            int all = list.size();
            for (int i = 0; i < list.size(); i++) {
                sum0 += Math.abs(list.get(i) - list.get(0));
            }
            res[index0] = sum0;
            for (int i = 1; i < list.size(); i++) {
                Integer index = list.get(i);
                long tmp = res[list.get(i - 1)] - (long) (all - i - 1) * (index - list.get(i - 1)) + (long) (i) * (index - list.get(i - 1));
                res[index] = tmp;
            }
        }
        return res;
    }
}
