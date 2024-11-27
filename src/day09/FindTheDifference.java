package day09;

import java.util.*;

public class FindTheDifference {
    /*
        给定两个字符串 s 和 t ，它们只包含小写字母。
        字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
        请找出在 t 中被添加的字母。
        示例 1：
                输入：s = "abcd", t = "abcde"
                输出："e"
                解释：'e' 是那个被添加的字母。
        示例 2：
                输入：s = "", t = "y"
                输出："y"
     */
    public static void main(String[] args) {
        String s = "abcd", t = "abcde";
        System.out.println(findTheDifference(s, t));
    }

    // 方法一：排序 + 遍历
    public static char findTheDifference(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return arr2[i];
        }
        return arr2[arr2.length - 1];
    }

    // 方法二：频次数组
    public static char findTheDifference1(String s, String t) {
        int[] count = new int[26];
        for (char c : t.toCharArray())
            count[c - 'a']++;
        for (char c : s.toCharArray())
            count[c - 'a']--;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0)
                return (char) (i + 'a');
        }
        return ' ';
    }

    // 方法三：异或操作
    public static char findTheDifference2(String s, String t) {
        char res = 0;
        for (char c : s.toCharArray())
            res ^= c;
        for (char c : t.toCharArray())
            res ^= c;
        return res;
    }
}
