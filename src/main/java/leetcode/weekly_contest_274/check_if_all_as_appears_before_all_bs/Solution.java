package leetcode.weekly_contest_274.check_if_all_as_appears_before_all_bs;

public class Solution {
    public boolean checkString(String s) {
        char[] chas = s.toCharArray();
        int firstBIndex = chas.length;
        for (int i = 0; i < chas.length; i++) {
            if (chas[i] == 'b') {
                firstBIndex = firstBIndex == chas.length ? i : firstBIndex;
            } else if (chas[i] == 'a') {
                if (firstBIndex != chas.length) {
                    return false;
                }
            }
        }
        return true;
    }
}
