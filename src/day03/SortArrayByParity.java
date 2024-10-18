package day03;

import java.util.Arrays;

public class SortArrayByParity {
    /*
        给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
        返回满足此条件的 任一数组 作为答案。
        示例 1：
                输入：nums = [3,1,2,4]
                输出：[2,4,3,1]
                解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
        示例 2：
                输入：nums = [0]
                输出：[0]
     */
    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        System.out.println(Arrays.toString(sortArrayByParity(arr)));
    }

    // 方法一：两次遍历
    public static int[] sortArrayByParity(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0;
        for (int num : nums) {
            if (num % 2 == 0)
                res[i++] = num;
        }

        for (int num : nums) {
            if (num % 2 != 0)
                res[i++] = num;
        }
        return res;
    }

    // 方法二：双指针 + 一次遍历
    public int[] sortArrayByParity1(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int l = 0, r = n - 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                res[l++] = num;
            } else {
                res[r--] = num;
            }
        }
        return res;
    }

    // 方法三：原地交换
    public int[] sortArrayByParity2(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            while (l < r && nums[l] % 2 == 0) {
                l++;
            }
            while (l < r && nums[r] % 2 == 1) {
                r--;
            }
            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
        }
        return nums;
    }
}
