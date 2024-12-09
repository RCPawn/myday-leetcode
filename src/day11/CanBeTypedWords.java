package day11;

import java.util.HashSet;
import java.util.Set;

public class CanBeTypedWords {
    /*
        键盘出现了一些故障，有些字母键无法正常工作。而键盘上所有其他键都能够正常工作。
        给你一个由若干单词组成的字符串 text ，
        单词间由单个空格组成（不含前导和尾随空格）；
        另有一个字符串 brokenLetters ，由所有已损坏的不同字母键组成，
        返回你可以使用此键盘完全输入的 text 中单词的数目。
        示例 1：
                输入：text = "hello world", brokenLetters = "ad"
                输出：1
                解释：无法输入 "world" ，因为字母键 'd' 已损坏。
        示例 2：
                输入：text = "leet code", brokenLetters = "lt"
                输出：1
                解释：无法输入 "leet" ，因为字母键 'l' 和 't' 已损坏。
        示例 3：
                输入：text = "leet code", brokenLetters = "e"
                输出：0
                解释：无法输入任何单词，因为字母键 'e' 已损坏。
     */
    public static void main(String[] args) {
        System.out.println(canBeTypedWords("leet code", "lt"));
    }

    // 方法一：
    public static int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> brokenSet = new HashSet<>();
        for (char c : brokenLetters.toCharArray())
            brokenSet.add(c);
        String[] words = text.split(" ");
        int res = words.length;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (brokenSet.contains(c)) {
                    res--;
                    break;
                }
            }
        }
        return res;
    }

    // 方法二：
    public static int canBeTypedWords1(String text, String brokenLetters) {
        String[] words = text.split(" ");
        Set<Character> set = new HashSet<>();
        int res = words.length;
        for (String word : words) {
            for (char c : word.toCharArray())
                set.add(c);
            for (char c : brokenLetters.toCharArray()) {
                if (set.contains(c)) {
                    res--;
                    break;
                }
            }
            set.clear();
        }
        return res;
    }
}
