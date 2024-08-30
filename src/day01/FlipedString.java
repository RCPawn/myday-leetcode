package day01;

public class FlipedString {
    /*
        字符串轮转。
        给定两个字符串s1和s2，
        请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。

        示例
            输入：s1 = "waterbottle", s2 = "erbottlewat"
            输出：True
     */
    public static void main(String[] args) {
        String s1 = "waterbottle", s2 = "erbottlewat";
        System.out.println(isFlipedString(s1, s2));
    }

    /*public static boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }*/

    public static boolean isFlipedString(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m != n)
            return false;
        if (n == 0)
            return true;

        for (int i = 0; i < n; i++) {
            boolean flag = true;
            //检查 s1 从 i 位置开始的旋转是否和 s2 匹配
            for (int j = 0; j < n; j++) {
                if (s1.charAt((i + j) % n) != s2.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            //找到一个匹配的旋转，返回 true
            if (flag)
                return true;
        }
        return false;
    }
}
