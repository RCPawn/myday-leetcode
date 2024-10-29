package day05;

public class ProjectionArea {
    /*
        在 n x n 的网格 grid 中，我们放置了一些与 x，y，z 三轴对齐的 1 x 1 x 1 立方体。
        每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
        现在，我们查看这些立方体在 xy 、yz 和 zx 平面上的投影。
        投影 就像影子，将 三维 形体映射到一个 二维 平面上。
        从顶部、前面和侧面看立方体时，我们会看到“影子”。
        返回 所有三个投影的总面积 。
        示例 1：
                输入：[[1,2],[3,4]]
                输出：17
                解释：这里有该形体在三个轴对齐平面上的三个投影(“阴影部分”)。
        示例 2:
                输入：grid = [[2]]
                输出：5
        示例 3：
                输入：[[1,0],[0,2]]
                输出：8
     */
    public static void main(String[] args) {
        int[][] grid = {
                {1, 2},
                {3, 4}
        };
        System.out.println(projectionArea(grid));
    }

    // 方法一：
    public static int projectionArea(int[][] grid) {
        // x-y (top view)
        int s1 = 0;
        for (int[] arr : grid) {
            for (int num : arr) {
                if (num > 0)
                    s1++; // 只计数大于0的单元格
            }
        }

        // x-z (front view)
        int s2 = 0;
        for (int[] arr : grid) {
            int max = 0;
            for (int num : arr) {
                if (num > max)
                    max = num;
            }
            s2 += max; // 每一行的最大值累加
        }

        // y-z (side view)
        int s3 = 0;
        for (int j = 0; j < grid[0].length; j++) {
            int max = 0;
            for (int[] arr : grid) {
                if (arr[j] > max)
                    max = arr[j];
            }
            s3 += max; // 每一列的最大值累加
        }
        return s1 + s2 + s3;
    }

    // 方法二：
    public int projectionArea1(int[][] grid) {
        int n = grid.length;
        int xyArea = 0, yzArea = 0, zxArea = 0;
        for (int i = 0; i < n; i++) {
            int yzHeight = 0, zxHeight = 0;
            for (int j = 0; j < n; j++) {
                xyArea += grid[i][j] > 0 ? 1 : 0;
                yzHeight = Math.max(yzHeight, grid[j][i]);
                zxHeight = Math.max(zxHeight, grid[i][j]);
            }
            yzArea += yzHeight;
            zxArea += zxHeight;
        }
        return xyArea + yzArea + zxArea;
    }
}
