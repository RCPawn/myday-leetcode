package day09;

import java.util.HashMap;
import java.util.Map;

public class FindLatestTime {
    /*
        给你一个字符串 s，表示一个 12 小时制的时间格式，
        其中一些数字（可能没有）被 "?" 替换。
        12 小时制时间格式为 "HH:MM" ，其中 HH 的取值范围为 00 至 11，
        MM 的取值范围为 00 至 59。最早的时间为 00:00，最晚的时间为 11:59。
        你需要将 s 中的 所有 "?" 字符替换为数字，
        使得结果字符串代表的时间是一个 有效 的 12 小时制时间，
        并且是可能的 最晚 时间。
        返回结果字符串。
        示例 1：
                输入： s = "1?:?4"
                输出： "11:54"
                解释： 通过替换 "?" 字符，可以得到的最晚12小时制时间是 "11:54"。
        示例 2：
                输入： s = "0?:5?"
                输出： "09:59"
                解释： 通过替换 "?" 字符，可以得到的最晚12小时制时间是 "09:59"。
     */
    public static void main(String[] args) {
        String s = "1?:?4";
        System.out.println(findLatestTime(s));
    }

    public static String findLatestTime(String s) {
        Map<Integer, Character> maxMap = new HashMap<>();
        maxMap.put(0, '1'); // 默认第1位为1（后续会调整）
        maxMap.put(1, '9');
        maxMap.put(3, '5');
        maxMap.put(4, '9');

        char[] res = s.toCharArray();
        for (int i = 0; i < res.length; i++) {
            if (res[i] == '?') {
                char max = maxMap.get(i);
                // 特殊处理第0位
                if (i == 0)
                    max = (res[1] == '?' || res[1] < '2') ? '1' : '0';
                // 特殊处理第1位
                if (i == 1)
                    max = (res[0] == '1') ? '1' : '9';
                res[i] = max; // 替换问号
            }
        }
        return new String(res);
    }
}
