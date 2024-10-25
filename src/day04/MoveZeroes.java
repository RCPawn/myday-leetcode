package day04;

import java.util.Arrays;

public class MoveZeroes {
    /*
        给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
        请注意 ，必须在不复制数组的情况下原地对数组进行操作。
        示例 1:
                输入: nums = [0,1,0,3,12]
                输出: [1,3,12,0,0]
        示例 2:
                输入: nums = [0]
                输出: [0]
     */
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 方法一：
    public static void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

    // 方法二：
    public static void moveZeroes1(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0;
        for (int num : nums) {
            if (num != 0)
                res[i++] = num;
        }
        for (int j = i; j < n; j++) {
            res[j] = 0;
        }
        System.arraycopy(res, 0, nums, 0, n);
    }

    // 方法三：
    public static void moveZeroes2(int[] nums) {
        if (nums == null) {
            return;
        }
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for (int i = j; i < nums.length; ++i) {
            nums[i] = 0;
        }
    }
}
