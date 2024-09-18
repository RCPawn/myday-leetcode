package day02;

public class ValidPalindrome {
    /*
        给你一个字符串 s，最多 可以从中删除一个字符。
        请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
        示例 1：
                输入：s = "aba"
                输出：true
        示例 2：
                输入：s = "abca"
                输出：true
                解释：你可以删除字符 'c' 。
     */
    public static void main(String[] args) {
        String s = "tebbem";
        System.out.println(validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r && s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        }
        return palindrome(s, l, r - 1) || palindrome(s, l + 1, r);
    }

    public static boolean palindrome(String s, int l, int r) {
        while (l < r && s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        }
        return l >= r;
    }
}
