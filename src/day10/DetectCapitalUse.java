package day10;

public class DetectCapitalUse {
    /*
        我们定义，在以下情况时，单词的大写用法是正确的：
        全部字母都是大写，比如 "USA" 。
        单词中所有字母都不是大写，比如 "leetcode" 。
        如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
        给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
        示例 1：
                输入：word = "USA"
                输出：true
        示例 2：
                输入：word = "FlaG"
                输出：false
     */
    public static void main(String[] args) {
        String word = "g";
        System.out.println(detectCapitalUse2(word));
    }

    // 方法一：
    public static boolean detectCapitalUse(String word) {
        int cnt = 0;
        for (int i = 0; i < word.length(); i++) {
            boolean upperCase = Character.isUpperCase(word.charAt(i));
            if (upperCase)
                cnt++;
            else if (Character.isUpperCase(word.charAt(i)))
                return false;
        }
        return cnt == 0
                || (cnt == 1 && Character.isUpperCase(word.charAt(0)))
                || cnt == word.length();
    }

    // 方法二：
    public static boolean detectCapitalUse1(String word) {
        return word.matches("^(?:[A-Z]+|[A-Z]?[a-z]+)$");
    }

    // 方法三：
    public static boolean detectCapitalUse2(String word) {
        return word.equals(word.toUpperCase())
                || word.equals(word.toLowerCase())
                || (Character.isUpperCase(word.charAt(0))
                && word.equals(word.charAt(0) + word.substring(1).toLowerCase()));
    }

}
