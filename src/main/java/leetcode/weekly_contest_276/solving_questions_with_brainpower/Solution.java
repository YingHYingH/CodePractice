package leetcode.weekly_contest_276.solving_questions_with_brainpower;

public class Solution {
    public long mostPoints(int[][] questions) {
        long[] arr = new long[questions.length];
        long max = 0;
        for (int i = 0; i < questions.length; i++) {
            if (i + 1 < questions.length) {
                arr[i + 1] = Math.max(arr[i + 1], arr[i]);
            }
            arr[i] += questions[i][0];
            int next = i + questions[i][1] + 1;
            if (next < questions.length) {
                arr[next] = Math.max(arr[i], arr[next]);
            }
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        new Solution().mostPoints(new int[][]{{12, 46}, {78, 19}, {63, 15}, {79, 62}, {13, 10}});
    }
}
