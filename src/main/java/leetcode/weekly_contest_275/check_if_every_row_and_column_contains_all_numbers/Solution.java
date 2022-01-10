package leetcode.weekly_contest_275.check_if_every_row_and_column_contains_all_numbers;

public class Solution {
    public boolean checkValid(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            int[][] arr = new int[2][n];
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < 1 || matrix[i][j] > n || arr[0][matrix[i][j] - 1] == 1) {
                    return false;
                }
                arr[0][matrix[i][j] - 1] = 1;
                if (matrix[j][i] < 1 || matrix[j][i] > n || arr[1][matrix[j][i] - 1] == 1) {
                    return false;
                }
                arr[1][matrix[j][i] - 1] = 1;
            }
        }
        return true;
    }
}