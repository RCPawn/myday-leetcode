package day02;

import java.util.ArrayList;
import java.util.List;

public class YHTriangle {
    /*
        杨辉三角
     */
    public static void main(String[] args) {
        List<List<Integer>> res = triangle(5);
        for (List<Integer> rows : res) {
            for (Integer row : rows) {
                System.out.print(row + " ");
            }
            System.out.println();
        }

        System.out.println();

        List<Integer> row = getRow(5);
        for (Integer i : row) {
            System.out.print(i + " ");
        }
    }

    //生成杨辉三角
    public static List<List<Integer>> triangle(int rows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < rows; i++)
            generate(res, i);

        return res;
    }

    //生成杨辉三角的某一行
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++)
            generate(list, i);

        return list.get(rowIndex);
    }

    private static void generate(List<List<Integer>> list, int i) {
        List<Integer> row = new ArrayList<>();
        for (int j = 0; j <= i; j++) {
            if (j == 0 || j == i)
                row.add(1);
            else
                row.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
        }
        list.add(row);
    }
}
