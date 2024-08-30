package day01;

import java.util.Arrays;

public class Rotate {
    /*
        给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。
        请你设计一种算法，将图像旋转 90 度。
     */
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        rotate(matrix);
        for (int[] ints : matrix)
            System.out.println(Arrays.toString(ints));
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] help = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j)
                help[j][n - i - 1] = matrix[i][j];
        }

        for (int i = 0; i < n; ++i)
            System.arraycopy(help[i], 0, matrix[i], 0, n);
    }

}
