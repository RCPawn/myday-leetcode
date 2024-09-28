package day03;

public class Fib {
    /*
        斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。
        该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
        F(0) = 0，F(1) = 1
        F(n) = F(n - 1) + F(n - 2)，其中 n > 1
        给定 n ，请计算 F(n)。
        示例 1：
                输入：n = 2
                输出：1
                解释：F(2) = F(1) + F(0) = 1 + 0 = 1
        示例 2：
                输入：n = 3
                输出：2
                解释：F(3) = F(2) + F(1) = 1 + 1 = 2
        示例 3：
                输入：n = 45
                输出：134903163
     */
    public static void main(String[] args) {
        System.out.println(fib(45));
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        final int MOD = 1000000007;
        int a = 1, b = 1, c = 0;
        for (int i = 3; i <= n; i++) {
            c = (a + b) % MOD;
            a = b;
            b = c;
        }
        return c;
    }
}
