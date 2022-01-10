package leetcode.weekly_contest_275.count_words_obtained_after_adding_a_letter;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        int res = 0;
        Set<Integer> hashSet = new HashSet<>();
        for (String startWord : startWords) {
            int mask = 0;
            char[] chas = startWord.toCharArray();
            for (char c : chas) {
                mask |= 1 << (c - 'a');
            }
            hashSet.add(mask);
        }

        for (String targetWord : targetWords) {
            int mask = 0;
            char[] chas = targetWord.toCharArray();
            for (char c : chas) {
                mask |= 1 << (c - 'a');
            }
            for (char c : chas) {
                if (hashSet.contains(mask ^ (1 << (c - 'a')))) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] start = new
                String[]{"g", "vf", "ylpuk", "nyf", "gdj", "j", "fyqzg", "sizec"};
        String[] end = new String[]{"r", "am", "jg", "umhjo", "fov", "lujy", "b", "uz", "y"};
        System.out.println(new Solution().wordCount(start, end));
    }
}
