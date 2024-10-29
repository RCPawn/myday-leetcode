package day05;

import java.util.ArrayList;
import java.util.List;

public class CountCharacters {
    /*
        给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
        假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），
        那么我们就认为你掌握了这个单词。
        注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
        返回词汇表 words 中你掌握的所有单词的 长度之和。
        示例 1：
                输入：words = ["cat","bt","hat","tree"], chars = "atach"
                输出：6
                解释：可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
        示例 2：
                输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
                输出：10
                解释：可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
     */
    public static void main(String[] args) {
        String[] words = {"hello", "world", "leetcode"};
        String chars = "welldonehoneyr";
        System.out.println(countCharacters(words, chars));
    }

    // 方法一：
    public static int countCharacters(String[] words, String chars) {
        int res = 0;
        for (String word : words) {
            List<Character> list = new ArrayList<>();
            for (char c : chars.toCharArray()) {
                list.add(c);
            }
            boolean flag = true;
            for (char c : word.toCharArray()) {
                if (list.contains(c)) {
                    // 'c' 会自动被转换成数字，导致下标越界
                    // Character.valueOf(c) 读取 'c' 的值
                    list.remove(Character.valueOf(c));
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag)
                res += word.length();
        }
        return res;
    }

    // 方法二：
    public static int countCharacters1(String[] words, String chars) {
        int res = 0;
        int[] charCount = new int[26];
        for (char c : chars.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (String word : words) {
            int[] wordCount = new int[26];
            for (char c : word.toCharArray()) {
                wordCount[c - 'a']++;
            }

            boolean canForm = true;
            for (int i = 0; i < 26; i++) {
                if (wordCount[i] > charCount[i]) {
                    canForm = false;
                    break;
                }
            }
            if (canForm) {
                res += word.length();
            }
        }
        return res;
    }

    // 方法三：
    /*public int countCharacters2(String[] words, String chars) {
        Map<Character, Integer> charsCnt = new HashMap<Character, Integer>();
        int length = chars.length();
        for (int i = 0; i < length; ++i) {
            char c = chars.charAt(i);
            charsCnt.put(c, charsCnt.getOrDefault(c, 0) + 1);
        }
        int ans = 0;
        for (String word : words) {
            Map<Character, Integer> wordCnt = new HashMap<Character, Integer>();
            int wordLength = word.length();
            for (int i = 0; i < wordLength; ++i) {
                char c = word.charAt(i);
                wordCnt.put(c, wordCnt.getOrDefault(c, 0) + 1);
            }
            boolean isAns = true;
            for (int i = 0; i < wordLength; ++i) {
                char c = word.charAt(i);
                if (charsCnt.getOrDefault(c, 0) < wordCnt.getOrDefault(c, 0)) {
                    isAns = false;
                    break;
                }
            }
            if (isAns) {
                ans += word.length();
            }
        }
        return ans;
    }*/
}
