package day02;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    /*  滑动窗口：
        给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。

        示例 1:
                输入: s = "abcabcbb"
                输出: 3
                解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
        示例 2:
                输入: s = "bbbbb"
                输出: 1
                解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
        示例 3:
                输入: s = "pwwkew"
                输出: 3
                解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
                     请注意，你的答案必须是子串的长度，"pwke" 是一个子序列，不是子串。
     */
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(longestSubstring(s));
    }

    // 方法一：
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int j = -1, maxLen = 0, n = s.length();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // i 指针向右移动一格，移除一个字符
                set.remove(s.charAt(i - 1));
            }
            while (j + 1 < n && !set.contains(s.charAt(j + 1))) {
                // 不断地移动 j 指针
                set.add(s.charAt(j + 1));
                ++j;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }

    // 方法二：
    public static int longestSubstring(String s) {
        // 存储每个字符的最新索引
        int[] charIndex = new int[128];
        int l = 0, r = 0, maxLen = 0;

        while (r < s.length()) {
            // 获取当前右指针指向的字符
            char c = s.charAt(r);
            // 更新左指针 l 的位置，确保窗口内没有重复字符
            l = Math.max(charIndex[c], l);
            maxLen = Math.max(maxLen, r - l + 1);
            // 更新当前字符的最新索引，+1是因为要表示下一个字符的位置
            charIndex[c] = r + 1;
            r++;
        }
        return maxLen;
    }

}
