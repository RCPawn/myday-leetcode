package day09;

import java.util.HashSet;
import java.util.Set;

public class CountConsistentStrings {
    /*
        给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。
        如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
        请你返回 words 数组中 一致字符串 的数目。
        示例 1：
                输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
                输出：2
                解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
        示例 2：
                输入：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
                输出：7
                解释：所有字符串都是一致的。
        示例 3：
                输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
                输出：4
                解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。
     */
    public static void main(String[] args) {
        String allowed = "cad";
        String[] words = {"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"};
        System.out.println(countConsistentStrings(allowed, words));
    }

    // 方法一：
    public static int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (char c : allowed.toCharArray())
            set.add(c);
        int count = 0;
        for (String word : words) {
            boolean flag = true;
            for (char c : word.toCharArray()) {
                if (!set.contains(c)) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                count++;
        }
        return count;
    }

    // 方法二：
    public static int countConsistentStrings1(String allowed, String[] words) {
        int mask = 0;
        for (int i = 0; i < allowed.length(); i++) {
            char c = allowed.charAt(i);
            mask |= 1 << (c - 'a');
        }
        int res = 0;
        for (String word : words) {
            int mask1 = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                mask1 |= 1 << (c - 'a');
            }
            if ((mask1 | mask) == mask)
                res++;
        }
        return res;
    }
}
