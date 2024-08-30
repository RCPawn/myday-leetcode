package day01;

import java.util.HashMap;
import java.util.Map;

public class CanPermutePalindrome {
    /*
        给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
        回文串是指正反两个方向都一样的单词或短语。
        排列是指字母的重新排列。
        回文串不一定是字典当中的单词。

        示例
            输入：s = "tactcoa"
            输出：true
     */
    public static void main(String[] args) {
        String s = "tactcoa";
        System.out.println(canPermutePalindrome(s));
    }

    public static boolean canPermutePalindrome(String s) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        // 统计每个字符的出现次数
        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        int oddCount = 0;

        // 统计出现次数为奇数的字符数量
        for (int count : charCountMap.values()) {
            if (count % 2 != 0)
                oddCount++;
        }

        // 允许最多一个字符出现次数为奇数
        return oddCount <= 1;
    }
}
