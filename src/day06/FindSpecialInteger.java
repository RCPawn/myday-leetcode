package day06;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindSpecialInteger {
    /*
        给你一个非递减的 有序 整数数组，
        已知这个数组中恰好有一个整数，
        它的出现次数超过数组元素总数的 25%。
        请你找到并返回这个整数
        示例：
            输入：arr = [1,2,2,6,6,6,6,7,10]
            输出：6
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 6, 6, 6, 6, 7, 10};
        System.out.println(findSpecialInteger(arr));
    }

    // 方法一：
    public static int findSpecialInteger(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int res = 0;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() > arr.length / 4)
                res = entry.getKey();
        }
        return res;
    }

    // 方法二：
    public static int findSpecialInteger1(int[] arr) {
        int n = arr.length;
        int cur = arr[0], cnt = 0;
        for (int num : arr) {
            if (num == cur) {
                ++cnt;
                if (cnt * 4 > n)
                    return cur;
            } else {
                cur = num;
                cnt = 1;
            }
        }
        return -1;
    }
}
