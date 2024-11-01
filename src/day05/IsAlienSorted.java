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
        1. 理解字母顺序 order
        由于“外星语”的字母顺序可能与普通字母顺序不同，我们需要用 order 来定义外星语中每个字母的位置。
        2. 构建字母位置映射
        创建一个 index 数组，表示每个字母在外星语中的排序位置。index[0] 存储字母 'a' 的排序位置，
        index[1] 存储字母 'b' 的位置，以此类推。例如，如果 order = "hlabcdefgijkmnopqrstuvwxyz"，
        我们会存储 'h' 在第 0 位，'l' 在第 1 位。
        3. 比较单词顺序
        按以下方法依次比较 words 中相邻的两个单词，确保它们是按 order 排列的：
        逐字符比较两个单词，直到找到第一个不同的字符。
        如果第一个不同字符的顺序不符合 order，说明单词顺序错误，返回 false。
        如果所有字符都相同，但前一个单词更长，例如 ["apple", "app"]，
        则该组单词也不是按字典序排列的，返回 false。
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
