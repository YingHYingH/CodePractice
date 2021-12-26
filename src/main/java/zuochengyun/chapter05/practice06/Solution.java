package zuochengyun.chapter05.practice06;

// 有问题！！！！！！！！
public class Solution {
    public String replace(String str, String from, String to) {
        if (str == null || from == null || str.equals("") || from.equals("")) {
            return str;
        }
        char[] chas = str.toCharArray();
        char[] chaf = from.toCharArray();
        int match = 0;
        for (int i = 0; i < chas.length; i++) {
            if (chas[i] == chaf[match++]) {
                if (match == chaf.length) {
                    clear(chas, i, chaf.length);
                    match = 0;
                }
            } else {
                match = 0;
            }
        }
        StringBuilder res = new StringBuilder();
        StringBuilder cur = new StringBuilder();
        for (int i = 0; i < chas.length; i++) {
            if (chas[i] != 0) {
                cur.append(chas[i]);
            }
            if (chas[i] == 0 && (i == 0 || chas[i - 1] != 0)) {
                res.append(cur).append(to);
                cur = new StringBuilder();
            }
        }
        if (!cur.toString().equals("")) {
            res.append(cur);
        }
        return res.toString();
    }

    public void clear(char[] chas, int end, int len) {
        while (len-- != 0) {
            chas[end--] = 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().replace("123abc", "abc", "4567"));
        System.out.println(new Solution().replace("1231234", "1234", "X"));
    }
}
