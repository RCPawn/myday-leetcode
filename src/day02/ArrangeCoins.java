package day02;

public class ArrangeCoins {
    /*
        你总共有 n 枚硬币，并计划将它们按阶梯状排列。
        对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。
        阶梯的最后一行可能是不完整的。
        给你一个数字 n ，计算并返回可形成完整阶梯行的总行数。
        示例 1：
                $
                $ $
                $ $ $
                $ $
                输入：n = 8
                输出：3
                解释：因为第三行不完整，所以返回 2 。
     */
    public static void main(String[] args) {
        System.out.println(arrangeCoins(5));
    }

    // 方法一：
    public static int arrangeCoins(int n) {
        int l = 1, r = n;
        // 使用二分查找，直到左右边界重合
        while (l < r) {
            // 计算中间值 mid
            int mid = (r - l + 1) / 2 + l;
            // 检查前 mid 行所需的硬币总数是否小于等于 n
            // 公式 mid * (mid + 1) / 2 计算前 mid 行所需的硬币数
            if ((long) mid * (mid + 1) <= (long) 2 * n) {
                // 如果可以用 n 个硬币形成 mid 行，更新左边界 l
                l = mid;
            } else {
                // 否则，更新右边界 r，缩小搜索范围
                r = mid - 1;
            }
        }
        // 返回最大能够排放的完整行数 l
        return l;
    }


    // 方法二：
    public int arrangeCoins1(int n) {
        return (int) ((Math.sqrt((long) 8 * n + 1) - 1) / 2);
    }

}
