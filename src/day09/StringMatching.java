package day09;

import java.util.*;

public class StringMatching {
    /*
        给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。
        请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词。
        如果你可以删除 words[j] 最左侧和/或最右侧的若干字符得到 words[i] ，
        那么字符串 words[i] 就是 words[j] 的一个子字符串。
        示例 1：
                输入：words = ["mass","as","hero","superhero"]
                输出：["as","hero"]
                解释："as" 是 "mass" 的子字符串，"hero" 是 "superhero" 的子字符串。
                ["hero","as"] 也是有效的答案。
        示例 2：
                输入：words = ["leetcode","et","code"]
                输出：["et","code"]
                解释："et" 和 "code" 都是 "leetcode" 的子字符串。
        示例 3：
                输入：words = ["blue","green","bu"]
                输出：[]
     */
    public static void main(String[] args) {
        String[] words = {"mass", "as", "hero", "superhero"};
        System.out.println(stringMatching(words));
    }

    // 方法一：
    public static List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }

    // 方法二：字符串拼接优化
    public static List<String> stringMatching1(String[] words) {
        List<String> res = new ArrayList<>();
        // 将所有单词拼接，避免重复判断
        String joined = String.join(" ", words);
        for (String word : words) {
            // 第一次出现的位置 不等于 最后一次出现的位置
            if (joined.indexOf(word) != joined.lastIndexOf(word))
                res.add(word);
        }
        return res;
    }

    // 方法三：排序 + 滑动窗口
    public static List<String> stringMatching2(String[] words) {
        List<String> res = new ArrayList<>();
        // 按长度排序
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (int i = 0; i < words.length; i++) {
            // 只检查较长的单词
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }
}
