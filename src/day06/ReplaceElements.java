package day06;

import java.util.Arrays;

public class ReplaceElements {
    /*
        给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，
        如果是最后一个元素，用 -1 替换。
        完成所有替换操作后，请你返回这个数组。
        示例 1：
                输入：arr = [17,18,5,4,6,1]
                输出：[18,6,6,6,1,-1]
                解释：
                - 下标 0 的元素 --> 右侧最大元素是下标 1 的元素 (18)
                - 下标 1 的元素 --> 右侧最大元素是下标 4 的元素 (6)
                - 下标 2 的元素 --> 右侧最大元素是下标 4 的元素 (6)
                - 下标 3 的元素 --> 右侧最大元素是下标 4 的元素 (6)
                - 下标 4 的元素 --> 右侧最大元素是下标 5 的元素 (1)
                - 下标 5 的元素 --> 右侧没有其他元素，替换为 -1
        示例 2：
                输入：arr = [400]
                输出：[-1]
                解释：下标 0 的元素右侧没有其他元素。
     */
    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};
        System.out.println(Arrays.toString(replaceElements(arr)));
    }

    // 方法一：
    public static int[] replaceElements(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > max)
                    max = arr[j];
            }
            arr[i] = max;
        }
        arr[n - 1] = -1;
        return arr;
    }

    // 方法二：
    public static int[] replaceElements1(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        res[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            res[i] = Math.max(res[i + 1], arr[i + 1]);
        }
        return res;
    }
}
