package day02;

public class LongestPalindrome {
    /*
        给你一个字符串 s，找到 s 中最长的回文子串。
        示例 1：
                输入：s = "babad"
                输出："bab"
                解释："aba" 同样是符合题意的答案。
        示例 2：
                输入：s = "cbbd"
                输出："bb"
     */
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (palindrome(s, i, j) && j - i + 1 > res.length())
                    res = s.substring(i, j + 1);
            }
        }
        return res;
    }

    public static boolean palindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
