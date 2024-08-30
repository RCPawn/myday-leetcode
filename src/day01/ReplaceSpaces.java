package day01;

public class ReplaceSpaces {
    /*
        URL化。编写一种方法，将字符串中的空格全部替换为%20。
        假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
        （注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）

        示例
            输入："Mr John Smith    ", 13
            输出："Mr%20John%20Smith"
     */
    public static void main(String[] args) {
        String S = "Mr John Smith    ";
        System.out.println(replaceSpaces(S, 13));
    }

    /*public static String replaceSpaces(String S, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (c == ' ')
                sb.append("%20");
            else
                sb.append(c);
        }
        return sb.toString();
    }*/

    public static String replaceSpaces(String S, int length) {
        return S.substring(0, length).replaceAll(" ", "%20");
    }
}
