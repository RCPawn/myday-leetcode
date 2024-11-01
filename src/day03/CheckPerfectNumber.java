package day03;

public class CheckPerfectNumber {
    /*
        对于一个正整数，如果它和除了它自身以外的所有正因子之和相等，
        我们称它为「完美数」。
        给定一个整数 n，如果是完美数，返回 true；否则返回 false。
        示例 1：
                输入：num = 28
                输出：true
                解释：28 = 1 + 2 + 4 + 7 + 14
                1, 2, 4, 7, 和 14 是 28 的所有正因子。
        示例 2：
                输入：num = 7
                输出：false
     */
    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(28));
    }

    // 方法一：
    public static boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int sum = 1;
        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                sum += i;
        }
        return sum == num;
    }

    // 方法二：
    public static boolean checkPerfectNumber1(int num) {
        if (num == 1) {
            return false;
        }
        int sum = 1;
        for (int d = 2; d * d <= num; ++d) {
            if (num % d == 0) {
                sum += d;
                if (d * d < num) {
                    sum += num / d;
                }
            }
        }
        return sum == num;
    }
}
