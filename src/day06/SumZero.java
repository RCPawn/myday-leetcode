package day06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumZero {
    /*
        给你一个整数 n，请你返回
        任意 一个由 n 个 各不相同的整数组成的数组，并且这 n 个数相加和为 0 。
        示例 1：
                输入：n = 5
                输出：[-7,-1,1,3,4]
                解释：这些数组也是正确的 [-5,-1,1,2,3]，[-3,-1,2,-2,4]。
        示例 2：
                输入：n = 3
                输出：[-1,0,1]
        示例 3：
                输入：n = 1
                输出：[0]
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(5)));
    }

    public static int[] sumZero(int n) {
        int[] res = new int[n];
        int id = 0;
        for (int i = 1; i <= n / 2; i++) {
            res[id++] = i;
            res[id++] = -i;
        }
        if (n % 2 != 0)
            res[id] = 0;
        return res;
    }

    public static int[] sumZero1(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n / 2; i++) {
            list.add(i);
            list.add(-i);
        }
        if (n % 2 != 0)
            list.add(0);
        // 集合转 int 数组
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
