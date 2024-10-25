package day04;

import java.util.Arrays;

public class MaximumProduct {
    /*
        给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
        示例 1：
                输入：nums = [1,2,3]
                输出：6
        示例 2：
                输入：nums = [1,2,3,4]
                输出：24
        示例 3：
                输入：nums = [-100,-98,-1,2,3,4]
                输出：39200
     */
    public static void main(String[] args) {
        int[] nums = {-100, -98, -1, 2, 3, 4};
        System.out.println(maximumProduct(nums));
    }

    // 方法一：
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);
    }

    // 方法二：
    public static int maximumProduct1(int[] nums) {
        // 最小的和第二小的
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        // 最大的、第二大的和第三大的
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int x : nums) {
            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }

            if (x > max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max3 = max2;
                max2 = x;
            } else if (x > max3) {
                max3 = x;
            }
        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
