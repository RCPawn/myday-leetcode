package day04;

import java.util.HashMap;
import java.util.Map;

public class Duplicate {
    /*
        在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
        数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
        请找出数组中任意一个重复的数字。
        Input:
                {2, 3, 1, 0, 2, 5}
        Output:
                2
     */
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5};
        System.out.println(duplicate(nums));
    }

    public static int duplicate(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        // 遍历数组，记录每个数字出现的次数
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        // 查找重复的数字
        // hm.entrySet() 获取所有键值对集合
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue() > 1) {
                return entry.getKey();  // 返回任意一个重复的数字
            }
        }
        return -1;
    }
}
