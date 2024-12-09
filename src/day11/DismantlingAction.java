package day11;

import java.util.HashMap;
import java.util.Map;

public class DismantlingAction {
    /*
        某套连招动作记作仅由小写字母组成的序列 arr，其中 arr[i] 第 i 个招式的名字。
        请返回第一个只出现一次的招式名称，如不存在请返回空格。
        示例 1：
                输入：arr = "abbccdeff"
                输出：'a'
        示例 2：
                输入：arr = "ccdd"
                输出：' '
     */
    public static void main(String[] args) {
        String arr=  "abbccdeff";
        System.out.println(dismantlingAction(arr));
    }

    // 方法一：
    public static char dismantlingAction(String arr) {
        int[] count = new int[26];
        for (char c : arr.toCharArray())
            count[c - 'a']++;
        for (char c : arr.toCharArray()) {
            if (count[c - 'a'] == 1)
                return c;
        }
        return ' ';
    }

    // 方法二：
    public static char dismantlingAction1(String arr) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : arr.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        for (char c : arr.toCharArray()) {
            if (map.get(c) == 1)
                return c;
        }
        return ' ';
    }
}
