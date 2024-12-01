package day10;

import java.util.*;

public class AreOccurrencesEqual {
    /*
        给你一个字符串 s ，如果 s 是一个 好 字符串，请你返回 true ，否则请返回 false 。
        如果 s 中出现过的 所有 字符的出现次数 相同 ，那么我们称字符串 s 是 好 字符串。
        示例 1：
                输入：s = "abacbc"
                输出：true
                解释：s 中出现过的字符为 'a'，'b' 和 'c' 。s 中所有字符均出现 2 次。
        示例 2：
                输入：s = "aaabb"
                输出：false
                解释：s 中出现过的字符为 'a' 和 'b' 。
                'a' 出现了 3 次，'b' 出现了 2 次，两者出现次数不同。
     */
    public static void main(String[] args) {
        String s = "abacbc";
        System.out.println(areOccurrencesEqual(s));
    }

    // 方法一：
    public static boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        Set<Integer> set = new HashSet<>(map.values());
        return set.size() == 1;
    }

    // 方法二：
    public static boolean areOccurrencesEqual1(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray())
            count[c - 'a']++;
        int f = -1;
        for (int c : count) {
            // 只检查出现过的字符
            if (c != 0) {
                if (f == -1)
                    f = c;  // 获取第一个非零字符的出现次数
                else if (c != f)
                    return false;
            }
        }
        return true;
    }

    public static boolean areOccurrencesEqual2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        // 获取出现次数的集合
        Collection<Integer> values = map.values();

        // 获取第一个字符的出现次数作为标准
        Integer firstCount = values.iterator().next();

        // 判断所有字符的出现次数是否相同
        for (Integer count : values) {
            if (!count.equals(firstCount))
                return false;
        }
        return true;
    }
}
