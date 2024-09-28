package day03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    /*
        数组nums包含从0到n的所有整数，但其中缺了一个。
        请编写代码找出那个缺失的整数。
        你有办法在O(n)时间内完成吗？
        示例 1：
                输入：[3,0,1]
                输出：2
        示例 2：
                输入：[9,6,4,2,3,5,7,0,1]
                输出：8
     */
    public static void main(String[] args) {
        int[] nums = {0, 1};
        System.out.println(missingNumber1(nums));
    }

    // 方法一（数学）：
    public static int missingNumber1(int[] nums) {
        int sum = 0, n = nums.length;
        int total = n * (n + 1) / 2;
        for (int num : nums) {
            sum += num;
        }
        return total - sum;
    }

    // 方法二（set集合）：
    public static int missingNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int num : nums) {
            set.add(num);
        }
        int res = -1;
        for (int i = 0; i <= n; i++) {
            if (!set.contains(i)) {
                res = i;
                break;
            }
        }
        return res;
    }

    // 方法三（位运算）：
    public int missingNumber3(int[] nums) {
        int xor = 0;
        int n = nums.length;
        for (int num : nums) {
            xor ^= num;
        }
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }
        return xor;
    }

    // 方法四：
    public static int missingNumber4(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n == 1) {
            if (nums[0] == 0)
                return 1;
            if (nums[0] == 1)
                return 0;
        }
        if (nums[0] != 0) {
            return 0;
        }
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] + 1 != nums[i + 1])
                return nums[i] + 1;
        }
        return nums[n - 1] + 1;
    }
}
