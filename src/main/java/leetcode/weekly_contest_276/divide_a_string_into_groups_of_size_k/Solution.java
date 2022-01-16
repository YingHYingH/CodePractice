package leetcode.weekly_contest_276.divide_a_string_into_groups_of_size_k;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String[] divideString(String s, int k, char fill) {
        char[] chas = s.toCharArray();
        int count = 0;
        int len = chas.length % k == 0 ? chas.length / k : chas.length / k + 1;
        String[] res = new String[len];
        StringBuffer sb = new StringBuffer();
        int index = 0;
        for (int i = 0; i < chas.length; i++) {
            sb.append(chas[i]);
            count++;
            if (count == k) {
                res[index++] = sb.toString();
                sb = new StringBuffer();
                count = 0;
            }
        }
        while (count != 0 && count < k) {
            sb.append(fill);
            count++;
        }
        if (count == k) {
            res[index++] = sb.toString();
        }
        return res;
    }
}
