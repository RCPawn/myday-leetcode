package day05;

import java.util.*;

public class HasGroupsSizeX {
    /*
        给定一副牌，每张牌上都写着一个整数。
        此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
        每组都有 X 张牌。
        组内所有的牌上都写着相同的整数。
        仅当你可选的 X >= 2 时返回 true。
        示例 1：
                输入：deck = [1,2,3,4,4,3,2,1]
                输出：true
                解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
        示例 2：
                输入：deck = [1,1,1,2,2,2,3,3]
                输出：false
                解释：没有满足要求的分组。
     */
    public static void main(String[] args) {
        int[] deck = {1, 1, 1, 2, 2, 2, 3, 3};
        System.out.println(hasGroupsSizeX(deck));
    }

    // 方法一：
    public static boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (int card : deck) {
            count[card]++;
        }

        List<Integer> list = new ArrayList<>();
        for (int val : count) {
            if (val > 0)
                list.add(val);
        }

        int n = deck.length;
        for (int x = 2; x <= n; x++) {
            boolean flag = true;
            if (n % x == 0) {
                for (int val : list) {
                    if (val % x != 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    return true;
            }
        }
        return false;
    }

    // 方法二：
    public static boolean hasGroupsSizeX1(int[] deck) {
        if (deck.length < 2) return false;

        Map<Integer, Integer> map = new HashMap<>();
        for (int card : deck) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        // 计算所有计数的最大公约数
        int gcd = -1;
        for (int val : map.values()) {
            if (gcd == -1)
                gcd = val;
            else
                gcd = gcd(gcd, val);
        }

        // 如果 gcd 大于等于 2，则可以将牌按题意分组
        return gcd >= 2;
    }

    // 辅助方法：计算两个数的最大公约数
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
