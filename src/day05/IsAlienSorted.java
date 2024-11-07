package day05;

public class IsAlienSorted {
    /*
        某种外星语也使用英文小写字母，但可能顺序 order 不同。
        字母表的顺序（order）是一些小写字母的排列。
        给定一组用外星语书写的单词 words，以及其字母表的顺序 order，
        只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
        示例 1：
                输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
                输出：true
                解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
        示例 2：
                输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
                输出：false
                解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，
                因此单词序列不是按字典序排列的。
        示例 3：
                输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
                输出：false
                解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，
                因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
     */
    public static void main(String[] args) {
        String[] words = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words, order));
    }

    /*
        1.构建外星语字母映射：
            使用一个 index 数组记录外星语字母表 order 中每个字母的索引位置。
            这样，我们可以用 index[char - 'a'] 快速获取外星语中任意字母的顺序。
        2.逐对比较相邻单词：
            对 words 数组中的相邻单词进行比较，确保它们的顺序符合外星语的字典序。
        3.单词比较规则：
            对于每一对单词，从左到右逐字符进行比较，找到第一个不同字符，
            并根据 index 数组判断该字符在外星语中的顺序。
            如果第一个不同字符在第一个单词中的优先级较低，则顺序正确；否则，返回 false。
            如果两个单词的字符都相同，但第一个单词比第二个单词长（如 ["apple", "app"]），
            则顺序不正确，返回 false。
     */
    public static boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < index.length; i++) {
            index[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            // 如果前一个单词比后一个单词更大，直接返回 false
            if (!inCorrectOrder(words[i - 1], words[i], index))
                return false;
        }
        return true;
    }

    // 比较两个单词是否按正确顺序排列
    private static boolean inCorrectOrder(String word1, String word2, int[] index) {
        int n = word1.length(), m = word2.length();
        for (int i = 0; i < Math.min(n, m); i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            if (c1 != c2)
                return index[c1 - 'a'] < index[c2 - 'a'];
        }
        return n <= m;
    }
}
