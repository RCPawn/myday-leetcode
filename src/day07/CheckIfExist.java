package day07;

import java.util.HashSet;
import java.util.Set;

public class CheckIfExist {
    /*
        给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，
        满足 N 是 M 的两倍（即，N = 2 * M）。
        更正式地，检查是否存在两个下标 i 和 j 满足：
        i != j
        0 <= i, j < arr.length
        arr[i] == 2 * arr[j]
        示例 1：
                输入：arr = [10,2,5,3]
                输出：true
                解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
        示例 2：
                输入：arr = [7,1,14,11]
                输出：true
                解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
        示例 3：
                输入：arr = [3,1,7,11]
                输出：false
                解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
     */
    public static void main(String[] args) {
        int[] arr = {-2, 0, 10, -19, 4, 6, -8};
        System.out.println(checkIfExist(arr));
    }

    // 方法一：
    public static boolean checkIfExist(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] * 2 == arr[j] || arr[i] == arr[j] * 2)
                    return true;
            }
        }
        return false;
    }

    // 方法二：
    public static boolean checkIfExist1(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(2 * num) || (set.contains(num / 2) && num % 2 == 0))
                return true;
            set.add(num);
        }
        return false;
    }
}
