package day02;

public class CountWordNum {
    /*
        统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
        请注意，你可以假定字符串里不包括任何不可打印的字符。
        示例:
            输入: "Hello, my name is John"
            输出: 5
            解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
     */
    public static void main(String[] args) {
        String s = "Hello, my name is John";
        System.out.println(countWordNum(s));
    }

    public static int countWordNum(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                count++;
                while (i < s.length() && s.charAt(i) != ' ')
                    i++;
            }
        }
        return count;
    }

    public int countSegments(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // 如果当前字符不是空格，且前一个字符是空格，
            // 或当前字符是字符串的开始，则认为找到了一个单词的开始
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ')
                count++;
        }
        return count;
    }

}
