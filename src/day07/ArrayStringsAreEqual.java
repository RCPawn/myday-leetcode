package day07;

public class ArrayStringsAreEqual {
    /*
        给你两个字符串数组 word1 和 word2 。
        如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
        数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
        示例 1：
                输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
                输出：true
                解释：
                word1 表示的字符串为 "ab" + "c" -> "abc"
                word2 表示的字符串为 "a" + "bc" -> "abc"
                两个字符串相同，返回 true
        示例 2：
                输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
                输出：false
        示例 3：
                输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
                输出：true
     */
    public static void main(String[] args) {
        String[] w1 = {"abc", "d", "defg"};
        String[] w2 = {"abcddefg"};
        System.out.println(arrayStringsAreEqual(w1, w2));
    }

    // 方法一：String.join
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1 = String.join("", word1);
        String s2 = String.join("", word2);
        return s1.equals(s2);
    }

    // 方法二：StringBuilder
    public static boolean arrayStringsAreEqual1(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (String s : word1) {
            sb1.append(s);
        }

        for (String s : word2) {
            sb2.append(s);
        }

        return sb1.toString().contentEquals(sb2);
    }
}
