package day01;

import java.util.Arrays;

public class SetZeroes {
    /*
        编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。

        示例
            输入：
                [
                  [0,1,2,0],
                  [3,4,5,2],
                  [1,3,1,5]
                ]
                输出：
                [
                  [0,0,0,0],
                  [0,4,5,0],
                  [0,3,1,0]
                ]
     */
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

        setZeroes(matrix);

        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0)
                    row[i] = col[j] = true;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j])
                    matrix[i][j] = 0;
            }
        }
    }
}
