package leetcode.weekly_contest_281.construct_string_with_repeat_limit;

public class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        char[] chars = s.toCharArray();
        int[] charNums = new int[26];
        for (char aChar : chars) {
            charNums[aChar - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int nextIndex = charNums.length - 1;
        for (int j = charNums.length - 1; j >= 0; j--) {
            if (nextIndex == j) {
                nextIndex--;
            }
            int repeat = 0;
            while (charNums[j] > 0) {
                if (repeat < repeatLimit) {
                    sb.append((char) ('a' + j));
                    charNums[j]--;
                    repeat++;
                } else {
                    if (nextIndex < 0) {
                        return sb.toString();
                    }
                    while (charNums[nextIndex] == 0) {
                        nextIndex--;
                        if (nextIndex < 0) {
                            return sb.toString();
                        }
                    }
                    sb.append((char) ('a' + nextIndex));
                    charNums[nextIndex]--;
                    repeat = 0;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new Solution().repeatLimitedString("cczazcc", 3);
    }
}
