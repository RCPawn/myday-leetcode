package day06;

public class KLengthApart {
    /*
        给你一个由若干 0 和 1 组成的数组 nums 以及整数 k。
        如果所有 1 都至少相隔 k 个元素，则返回 true ；否则，返回 false 。
        示例 1：
                输入：nums = [1,0,0,0,1,0,0,1], k = 2
                输出：true
                解释：每个 1 都至少相隔 2 个元素。
        示例 2：
                输入：nums = [1,0,0,1,0,1], k = 2
                输出：false
                解释：第二个 1 和第三个 1 之间只隔了 1 个元素。
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 0, 0, 0, 1, 0, 0, 1};
        System.out.println(kLengthApart(nums1, 2)); // true

        int[] nums2 = {1, 0, 0, 1, 0, 1};
        System.out.println(kLengthApart(nums2, 2)); // false
    }

    public static boolean kLengthApart(int[] nums, int k) {
        int pre = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (pre != -1 && (i - pre - 1) < k)
                    return false;
                pre = i;
            }
        }
        return true;
    }
}
