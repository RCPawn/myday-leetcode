package day07;

import java.util.HashMap;
import java.util.Map;

public class MaximumPopulation {
    /*
        给你一个二维整数数组 logs ，其中每个 logs[i] = [birthi, deathi] 表示第 i 个人的出生和死亡年份。
        年份 x 的 人口 定义为这一年期间活着的人的数目。
        第 i 个人被计入年份 x 的人口需要满足：x 在闭区间 [birthi, deathi - 1] 内。
        注意，人不应当计入他们死亡当年的人口中。
        返回 人口最多 且 最早 的年份。
        示例 1：
                输入：logs = [[1993,1999],[2000,2010]]
                输出：1993
                解释：人口最多为 1 ，而 1993 是人口为 1 的最早年份。
        示例 2：
                输入：logs = [[1950,1961],[1960,1971],[1970,1981]]
                输出：1960
                解释：
                人口最多为 2 ，分别出现在 1960 和 1970 。
                其中最早年份是 1960 。
     */
    public static void main(String[] args) {
        int[][] logs = {
                {1950, 1961},
                {1960, 1971},
                {1970, 1981}
        };
        System.out.println(maximumPopulation(logs));
    }

    // 方法一：
    public static int maximumPopulation(int[][] logs) {
        int[] diff = new int[2051];

        for (int[] log : logs) {
            int birth = log[0];
            int death = log[1];
            diff[birth] += 1;
            diff[death] -= 1;
        }

        int maxPop = 0, curPop = 0, maxYear = 1950;
        for (int year = 1950; year <= 2050; year++) {
            curPop += diff[year];  // 当前年份人口数
            if (curPop > maxPop) {
                maxPop = curPop;
                maxYear = year;
            }
        }
        return maxYear;
    }

    // 方法二：
    public static int maximumPopulation1(int[][] logs) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] log : logs) {
            int birth = log[0];
            int death = log[1];
            map.put(birth, map.getOrDefault(birth, 0) + 1);
            map.put(death, map.getOrDefault(death, 0) - 1);
        }

        int maxPop = 0;
        int maxYear = 1950;
        int curPop = 0;

        for (int year = 1950; year <= 2050; year++) {
            curPop += map.getOrDefault(year, 0);
            if (curPop > maxPop) {
                maxPop = curPop;
                maxYear = year;
            }
        }
        return maxYear;
    }
}
