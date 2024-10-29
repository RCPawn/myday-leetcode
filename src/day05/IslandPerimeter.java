package day05;

public class IslandPerimeter {
    /*
        给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
        网格中的格子 水平和垂直 方向相连（对角线方向不相连）。
        整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
        岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。
        格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。
        计算这个岛屿的周长。
        示例 1：
                输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
                输出：16
                解释：它的周长是上面图片中的 16 个黄色的边
        示例 2：
                输入：grid = [[1]]
                输出：4
        示例 3：
                输入：grid = [[1,0]]
                输出：4
     */
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println(islandPerimeter(grid));
    }

    public static int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    res += 4;
                    // 检查上方
                    if (i > 0 && grid[i - 1][j] == 1)
                        res -= 2; // 上方相邻则减少2条共享边
                    // 检查左方
                    if (j > 0 && grid[i][j - 1] == 1)
                        res -= 2; // 左方相邻则减少2条共享边
                }
            }
        }
        return res;
    }
}
