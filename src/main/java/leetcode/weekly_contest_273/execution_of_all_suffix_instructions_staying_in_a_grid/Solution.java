package leetcode.weekly_contest_273.execution_of_all_suffix_instructions_staying_in_a_grid;

public class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        char[] chas = s.toCharArray();
        int[] res = new int[chas.length];
        for (int i = 0; i < chas.length; i++) {
            int tmp = 0;
            int row = startPos[0];
            int line = startPos[1];
            for (int j = i; j < chas.length; j++) {
                switch (chas[j]) {
                    case 'L':
                        line--;
                        break;
                    case 'R':
                        line++;
                        break;
                    case 'U':
                        row--;
                        break;
                    case 'D':
                        row++;
                        break;
                }
                if (row < 0 || row > n - 1 || line < 0 || line > n - 1) {
                    res[i] = tmp;
                    break;
                }
                tmp++;
            }
            res[i] = tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().executeInstructions(3, new int[]{0, 1}, "RRDDLU");
    }
}
