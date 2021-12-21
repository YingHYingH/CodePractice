package zuochengyun.chapter05.practice04;

public class Solution {
    public boolean isRotation(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }
        String b2 = b + b;
        return true;
//        return getIndexOf(b2, a) != -1; KMP算法 O(N)
    }
}
