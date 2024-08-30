package day01;

public class OneEditAway {
    /*
        字符串有三种编辑操作:插入一个英文字符、删除一个英文字符或者替换一个英文字符。
        给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。

        示例
            输入: s1 = "pales", s2 = "pal"
            输出: False
     */
    public static void main(String[] args) {
        String s1 = "pales", s2 = "pal";
        System.out.println(oneEditAway(s1, s2));
    }

    public static boolean oneEditAway(String s1, String s2) {
        int len1 = s1.length() - 1;
        int len2 = s2.length() - 1;

        int i = 0, j = 0;
        while (i <= len1 && j <= len2) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++; //移动 s1 的索引
                j++; //移动 s2 的索引
                continue; //跳出当前循环，继续下一个字符的比较
            }
            if (s1.charAt(len1) == s2.charAt(len2)) {
                len1--;
                len2--;
            } else {
                break; //如果末尾字符不相等，退出循环
            }
        }

        return (len1 - i + len2 - j <= 0) && Math.abs(i - j) <= 1 && Math.abs(len1 - len2) <= 1;
    }

    /*public static boolean oneEditAway(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        // Length difference check
        if (Math.abs(len1 - len2) > 1) {
            return false;
        }

        if (len1 > len2) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }

        int i = 0, j = 0;
        boolean foundDifference = false;

        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) != s2.charAt(j)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;

                if (len1 == len2) {
                    i++;
                }
            } else {
                i++;
            }
            j++;
        }

        return true;
    }*/
}
