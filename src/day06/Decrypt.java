package day06;

import java.util.Arrays;

public class Decrypt {
    /*
        你有一个炸弹需要拆除，时间紧迫！
        你的情报员会给你一个长度为 n 的 循环 数组 code 以及一个密钥 k 。
        为了获得正确的密码，你需要替换掉每一个数字。所有数字会 同时 被替换。
        如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换。
        如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
        如果 k == 0 ，将第 i 个数字用 0 替换。
        由于 code 是循环的， code[n-1] 下一个元素是 code[0] ，
        且 code[0] 前一个元素是 code[n-1] 。
        给你 循环 数组 code 和整数密钥 k ，
        请你返回解密后的结果来拆除炸弹！
        示例 1：
                输入：code = [5,7,1,4], k = 3
                输出：[12,10,16,13]
                解释：每个数字都被接下来 3 个数字之和替换。
                解密后的密码为 [7+1+4, 1+4+5, 4+5+7, 5+7+1]。
                注意到数组是循环连接的。
        示例 2：
                输入：code = [1,2,3,4], k = 0
                输出：[0,0,0,0]
                解释：当 k 为 0 时，所有数字都被 0 替换。
        示例 3：
                输入：code = [2,4,9,3], k = -2
                输出：[12,5,6,13]
                解释：解密后的密码为 [3+9, 2+3, 4+2, 9+4] 。
                注意到数组是循环连接的。
                如果 k 是负数，那么和为 之前 的数字。
     */
    public static void main(String[] args) {
        int[] code = {2, 4, 9, 3};
        System.out.println(Arrays.toString(decrypt(code, -2)));
    }

    // 方法一：
    public static int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];

        if (k == 0)
            return res;

        int[] arr = new int[n * 2];
        System.arraycopy(code, 0, arr, 0, n);
        System.arraycopy(code, 0, arr, n, n);

        // 定义窗口的左边界和右边界
        // 如果 k > 0，从当前元素的下一个元素开始，窗口范围为 [1, k]
        // 如果 k < 0，从当前元素之前的元素开始，窗口范围为 [n + k, n - 1]
        int l = k > 0 ? 1 : n + k;
        int r = k > 0 ? k : n - 1;

        // 初始化窗口的和 w
        int w = 0;
        for (int i = l; i <= r; i++)
            w += arr[i];

        // 通过滑动窗口的方式来计算每个位置的结果
        for (int i = 0; i < n; i++) {
            res[i] = w;
            // 滑动窗口：从窗口的左边界移出一个元素，从右边界移入一个新元素
            w -= arr[l];
            w += arr[r + 1];
            l++;
            r++;
        }
        return res;
    }

    // 方法二：
    public static int[] decrypt1(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];

        if (k == 0)
            return res;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            if (k > 0) {
                for (int j = 1; j <= k; j++)
                    sum += code[(i + j) % n];
            } else {
                for (int j = n + k; j <= n - 1; j++)
                    sum += code[(i + j) % n];
            }
            res[i] = sum;
        }
        return res;
    }
}
