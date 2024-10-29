package day05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindWords {
    /*
        给你一个字符串数组 words ，只返回可以使用在美式键盘同一行的字母打印出来的单词。
        美式键盘中：
        第一行由字符 "qwertyuiop" 组成。
        第二行由字符 "asdfghjkl" 组成。
        第三行由字符 "zxcvbnm" 组成。
        示例 1：
                输入：words = ["Hello","Alaska","Dad","Peace"]
                输出：["Alaska","Dad"]
        示例 2：
                输入：words = ["omk"]
                输出：[]
        示例 3：
                输入：words = ["adsdf","sfd"]
                输出：["adsdf","sfd"]
     */
    public static void main(String[] args) {
        String[] words = {"Hello","Alaska","Dad","Peace"};
        for (String word : findWords(words)) {
            System.out.println(word);
        }
    }

    public static String[] findWords(String[] words) {
        Set<Character> row1 = new HashSet<>();
        for (char c : "qwertyuiop".toCharArray()) row1.add(c);
        Set<Character> row2 = new HashSet<>();
        for (char c : "asdfghjkl".toCharArray()) row2.add(c);
        Set<Character> row3 = new HashSet<>();
        for (char c : "zxcvbnm".toCharArray()) row3.add(c);

        List<String> res = new ArrayList<>();
        for (String word : words) {
            String lowerWord = word.toLowerCase();
            Set<Character> row = null;
            // 判断单词首字母所在的行
            if (row1.contains(lowerWord.charAt(0))) row = row1;
            else if (row2.contains(lowerWord.charAt(0))) row = row2;
            else if (row3.contains(lowerWord.charAt(0))) row = row3;
            // 检查单词是否都在同一行
            boolean isValid = true;
            for (char c : lowerWord.toCharArray()) {
                if (row != null && !row.contains(c)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) res.add(word);
        }
        return res.toArray(new String[0]);
    }
}
