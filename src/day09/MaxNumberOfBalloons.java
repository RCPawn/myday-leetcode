package day09;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfBalloons {
    /*
        给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
        字符串 text 中的每个字母最多只能被使用一次。
        请你返回最多可以拼凑出多少个单词 "balloon"。
        示例 1：
                输入：text = "nlaebolko"
                输出：1
        示例 2：
                输入：text = "loonbalxballpoon"
                输出：2
        示例 3：
                输入：text = "leetcode"
                输出：0
     */
    public static void main(String[] args) {
        String text = "loonbalxballpoon";
        System.out.println(maxNumberOfBalloons(text));
    }

    public static int maxNumberOfBalloons(String text) {
        // 定义 balloon 中每个字母需要的数量
        Map<Character, Integer> balloonMap = new HashMap<>();
        balloonMap.put('b', 1);
        balloonMap.put('a', 1);
        balloonMap.put('l', 2);
        balloonMap.put('o', 2);
        balloonMap.put('n', 1);

        // 统计 text 中每个字母出现的次数
        Map<Character, Integer> textMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            textMap.put(c, textMap.getOrDefault(c, 0) + 1);
        }

        // 计算最多可以拼出几个 balloon
        int res = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : balloonMap.entrySet()) {
            char c = entry.getKey();
            int required = entry.getValue();
            // 从 textMap 中获取键为 c 的值，
            // 如果 c 不存在于 textMap 中，则返回默认值 0。
            int available = textMap.getOrDefault(c, 0);
            res = Math.min(res, available / required);
        }
        return res;
    }
}
