package day02;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    /*
        给定一个整数数组 nums 和一个整数目标值 target，
        请你在该数组中找出和为目标值 target 的那两个整数，并返回它们的数组下标。
        你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
        你可以按任意顺序返回答案。
        示例 1：
                输入：nums = [2,7,11,15], target = 9
                输出：[0,1]
                解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     */
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum2(nums, 9)));
    }

    // 方法一：
    public static int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    // 方法二：
    public static int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                res[0] = map.get(key);
                res[1] = i;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
