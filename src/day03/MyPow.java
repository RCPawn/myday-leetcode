package day03;

public class MyPow {
    /*
        实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
        示例 1：
                输入：x = 2.00000, n = 10
                输出：1024.00000

        示例 2：
                输入：x = 2.10000, n = 3
                输出：9.26100

        示例 3：
                输入：x = 2.00000, n = -2
                输出：0.25000
                解释：2 ^ -2 = 1 / 2 ^ 2 = 1/4 = 0.25
     */
    public static void main(String[] args) {
        System.out.printf("%.5f", myPow(2.00000, -2));
    }

    public static double myPow(double x, int n) {
        return (long) n >= 0 ? quickMul(x, n) : 1.0 / quickMul(x, -(long) n);
    }

    // 方法一：
    public static double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    // 方法二：
    public static double quickMul1(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }
}
