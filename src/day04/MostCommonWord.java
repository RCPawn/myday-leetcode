package day04;

import java.util.*;

public class MostCommonWord {
    /*
        给你一个字符串 paragraph 和一个表示禁用词的字符串数组 banned ，返回出现频率最高的非禁用词。
        题目数据保证至少存在一个非禁用词，且答案唯一 。
        paragraph 中的单词不区分大小写 ，答案应以小写形式返回。
        示例 1：
                输入：paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
                输出："ball"
                解释：
                "hit" 出现了 3 次，但它是禁用词。
                "ball" 出现了两次（没有其他单词出现这么多次），因此它是段落中出现频率最高的非禁用词。
                请注意，段落中的单词不区分大小写，
                标点符号会被忽略（即使它们紧挨着单词，如 "ball,"），
                并且尽管 "hit" 出现的次数更多，但它不能作为答案，因为它是禁用词。
        示例 2：
                输入：paragraph = "a.", banned = []
                输出："a"
     */
    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(mostCommonWord(paragraph, banned));
    }

    // 方法一：字符串逐个处理 + 手动构造词
    public static String mostCommonWord1(String paragraph, String[] banned) {
        Set<String> banSet = new HashSet<>(Arrays.asList(banned));
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> frequencyMap = new HashMap<>();
        int n = paragraph.length();
        int maxCount = 0;
        for (int i = 0; i <= n; i++) {
            // 检查当前字符是否在范围内，并且是否是字母
            if (i < n && Character.isLetter(paragraph.charAt(i))) {
                // 将字母转为小写并添加到 StringBuilder 中
                sb.append(Character.toLowerCase(paragraph.charAt(i)));
            } else if (sb.length() > 0) {
                // 如果 StringBuilder 中有内容，表示一个单词的结束
                String word = sb.toString();
                if (!banSet.contains(word)) {
                    int count = frequencyMap.getOrDefault(word, 0) + 1;
                    frequencyMap.put(word, count);
                    maxCount = Math.max(maxCount, count);
                }
                sb.setLength(0);
            }
        }

        String res = "";
        Set<Map.Entry<String, Integer>> entries = frequencyMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String word = entry.getKey();
            int count = entry.getValue();
            if (count == maxCount) {
                res = word;
                break;
            }
        }
        return res;
    }

    // 方法二：流式处理 + 正则表达式
    public static String mostCommonWord(String paragraph, String[] banned) {
        // 将 banned 数组转换为 Set
        Set<String> banSet = new HashSet<>(Arrays.asList(banned));

        // 使用正则表达式将段落中的标点符号替换为空格，并将字符串转换为小写字母
        String[] words = paragraph
                .toLowerCase()
                .replaceAll("[^a-z]", " ")
                .split("\\s+"); // 从空格处分离

        // 使用一个 Map 来存储单词及其出现的频率
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            if (!banSet.contains(word) && !word.isEmpty()) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }

        // 查找出现频率最高的单词
        return frequencyMap.entrySet()
                .stream()
                .filter(entry -> !banSet.contains(entry.getKey())) // 过滤掉禁用词
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }
}
