package day10;

public class IsLongPressedName {
    /*
        你的朋友正在使用键盘输入他的名字 name。
        偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
        你将会检查键盘输入的字符 typed。
        如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
        示例 1：
                输入：name = "alex", typed = "aaleex"
                输出：true
                解释：'alex' 中的 'a' 和 'e' 被长按。
        示例 2：
                输入：name = "saeed", typed = "ssaaedd"
                输出：false
                解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
     */
    public static void main(String[] args) {
        System.out.println(isLongPressedName("alex", "aaleex"));
    }

    public static boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1))
                j++;
            else
                return false;
        }
        return i == name.length();
    }
}
