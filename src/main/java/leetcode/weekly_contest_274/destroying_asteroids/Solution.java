package leetcode.weekly_contest_274.destroying_asteroids;

import java.util.Arrays;

public class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long newMass = mass;
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] <= newMass) {
                newMass += asteroids[i];
            } else {
                return false;
            }
        }
        return true;
    }
}
