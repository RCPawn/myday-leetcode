package day07;

import java.util.Arrays;

public class InventoryManagement {
    /*
        仓库管理员以数组 stock 形式记录商品库存表，其中 stock[i] 表示对应商品库存余量。
        请返回库存余量最少的 cnt 个商品余量，返回 顺序不限。
        示例 1：
                输入：stock = [2,5,7,4], cnt = 1
                输出：[2]
        示例 2：
                输入：stock = [0,2,3,6], cnt = 2
                输出：[0,2] 或 [2,0]
     */
    public static void main(String[] args) {
        int[] stock = {0,2,3,6};
        System.out.println(Arrays.toString(inventoryManagement(stock, 2)));
    }

    public static int[] inventoryManagement(int[] stock, int cnt) {
        int[] res = new int[cnt];
        Arrays.sort(stock);
        System.arraycopy(stock, 0, res, 0, cnt);
        return res;
    }
}
