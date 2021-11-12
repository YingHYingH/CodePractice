package leetcode.weekly_contest_254.number_of_strings_that_appear_as_substrings_in_word;

public class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int res = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numOfStrings(new String[]{"a","a","a"},"ab"));
    }
}
