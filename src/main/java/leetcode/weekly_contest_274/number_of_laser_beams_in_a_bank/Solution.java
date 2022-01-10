package leetcode.weekly_contest_274.number_of_laser_beams_in_a_bank;

public class Solution {
    public int numberOfBeams(String[] bank) {
        if (bank == null || bank.length == 0 || bank.length == 1) {
            return 0;
        }
        int n = bank[0].length();
        if (n == 0) {
            return 0;
        }
        int[] deviceNums = new int[bank.length];
        for (int i = 0; i < bank.length; i++) {
            char[] chas = bank[i].toCharArray();
            int deviceNum = 0;
            for (int j = 0; j < chas.length; j++) {
                if (chas[j] == '1') {
                    deviceNum++;
                }
            }
            deviceNums[i] = deviceNum;
        }
        int sum = 0;
        for (int i = 0; i < deviceNums.length - 1; ) {
            int deviceNum1 = deviceNums[i];
            if (deviceNum1 == 0) {
                i++;
                continue;
            }
            int j = i + 1;
            for (; j < deviceNums.length; j++) {
                int deviceNum2 = deviceNums[j];
                if (deviceNum2 == 0) {
                    continue;
                }
                sum += deviceNum1 * deviceNum2;
                break;
            }
            i = j;
        }
        return sum;
    }
}
