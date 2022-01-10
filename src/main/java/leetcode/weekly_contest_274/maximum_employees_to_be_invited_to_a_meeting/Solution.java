package leetcode.weekly_contest_274.maximum_employees_to_be_invited_to_a_meeting;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int maximumInvitations(int[] favorite) {
        int[] deg = new int[favorite.length];
        for (int i = 0; i < favorite.length; i++) {
            deg[favorite[i]]++;
        }

        int max = 0;
        for (int i = 0; i < favorite.length; i++) {
            List<Integer> list = new ArrayList<>(favorite.length);
            list.add(i);
            max = Math.max(max, invitations(favorite, list, max, deg));
            System.out.println(max);
        }
        return max;
    }

    public int invitations(int[] favorite, List<Integer> list, int max, int[] deg) {
        int favoriteIndex = favorite[list.get(list.size() - 1)];
        if (list.contains(favoriteIndex)) {
            if (favoriteIndex == list.get(0)) {
                return Math.max(max,list.size());
            } else if (favoriteIndex == list.get(list.size() - 2)) {
                max = Math.max(max, list.size());
                for (int i = 0; i < favorite.length; i++) {
                    if (list.contains(i)) {
                        continue;
                    }
                    list.add(i);
                    max = Math.max(max, invitations(favorite, new ArrayList<>(list), max, deg));
                    list.remove(list.size() - 1);
                }
                return max;
            } else {
                return max;
            }
        }
        list.add(favoriteIndex);
        return invitations(favorite, list, max, deg);
    }

    public static void main(String[] args) {
        int[] favorite = new int[]{1, 0, 0, 2, 1, 4, 7, 8, 9, 6, 7, 10, 8};
        new Solution().maximumInvitations(favorite);
    }
}