package leetcode.weekly_contest_275.earliest_possible_day_of_full_bloom;

import java.util.Arrays;

public class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        PG[] pgs = new PG[plantTime.length];
        for (int i = 0; i < pgs.length; i++) {
            pgs[i] = new PG(plantTime[i], growTime[i]);
        }
        // 根据G从大到小排序
        Arrays.sort(pgs, (a, b) -> b.G - a.G);
        int res = 0;
        int days = 0;
        for (PG pg : pgs) {
            days += pg.P;
            res = Math.max(res, days + pg.G);
        }
        return res;
    }

    class PG {
        int P;
        int G;

        public PG(int p, int g) {
            this.P = p;
            this.G = g;
        }
    }
}
