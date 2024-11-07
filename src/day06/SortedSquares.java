package day06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedSquares {
    /*
        给你一个按 非递减顺序 排序的整数数组 nums，
        返回每个数字的平方组成的新数组，要求也按 非递减顺序 排序。
        示例 1：
                输入：nums = [-4,-1,0,3,10]
                输出：[0,1,9,16,100]
                解释：平方后，数组变为 [16,1,0,9,100]
                排序后，数组变为 [0,1,9,16,100]
        示例 2：
                输入：nums = [-7,-3,2,3,11]
                输出：[4,9,9,49,121]
     */
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            res[i] = nums[i] * nums[i];
        }
        Arrays.sort(res);
        return res;
    }
}
