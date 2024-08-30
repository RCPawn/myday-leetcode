package day01;

public class CompressString {
    /*
        字符串压缩。
        利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
        若“压缩”后的字符串没有变短，则返回原先的字符串。
        你可以假设字符串中只包含大小写英文字母（a至z）。

        示例
            输入：s = "aabcccccaaa"
            输出：a2b1c5a3
     */
    public static void main(String[] args) {
        String s = "aabcccccaaa";
        System.out.println(compressString(s));
    }

    public static String compressString(String S) {
        int n = S.length();
        if (n == 0)
            return S;
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char c = S.charAt(0);
        for (int i = 1; i < n; i++) {
            if (c == S.charAt(i)) {
                count++;
            } else {
                sb.append(c);
                sb.append(count);
                c = S.charAt(i);
                count = 1;
            }
        }
        sb.append(c);
        sb.append(count);
        return sb.length() >= n ? S : sb.toString();
    }
}
