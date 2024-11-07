package day06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LuckyNumbers {
    /*
        给你一个 m x n 的矩阵，矩阵中的数字各不相同。
        请你按任意顺序返回矩阵中的所有幸运数。
        幸运数是指矩阵中满足同时下列两个条件的元素：
        在同一行的所有元素中最小
        在同一列的所有元素中最大
     */
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 10, 4, 2},
                {9, 3, 8, 7},
                {15, 16, 17, 12}
        };
        System.out.println(luckyNumbers(matrix).toString());
    }

    // 方法一：
    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        for (int[] ints : matrix) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] < min) {
                    min = ints[j];
                    minIndex = j;
                }
            }
            int max = Integer.MIN_VALUE;
            for (int[] value : matrix) {
                if (value[minIndex] > max)
                    max = value[minIndex];
            }
            if (min == max)
                list.add(min);
        }
        return list;
    }

    // 方法二：
    public static List<Integer> luckyNumbers1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] minRow = new int[m];
        Arrays.fill(minRow, Integer.MAX_VALUE);
        int[] maxCol = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                minRow[i] = Math.min(minRow[i], matrix[i][j]);
                maxCol[j] = Math.max(maxCol[j], matrix[i][j]);
            }
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == minRow[i] && matrix[i][j] == maxCol[j]) {
                    ret.add(matrix[i][j]);
                }
            }
        }
        return ret;
    }

    // 方法三：
    public static List<Integer> luckyNumbers2(int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();
        int n = matrix[0].length;
        // 存储每一行的最小值及其列索引
        for (int[] ints : matrix) {
            int min = ints[0];
            int minIndex = 0;
            // 找到当前行的最小值及其列索引
            for (int j = 1; j < n; j++) {
                if (ints[j] < min) {
                    min = ints[j];
                    minIndex = j;
                }
            }
            // 检查这个最小值是否是其列中的最大值
            boolean isLucky = true;
            for (int[] value : matrix) {
                if (value[minIndex] > min) {
                    isLucky = false;
                    break;
                }
            }
            // 如果是幸运数，则添加到列表
            if (isLucky)
                luckyNumbers.add(min);
        }
        return luckyNumbers;
    }
}
