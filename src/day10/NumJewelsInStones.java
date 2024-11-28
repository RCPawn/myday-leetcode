package day10;

import java.util.HashSet;
import java.util.Set;

public class NumJewelsInStones {
    /*
         给你一个字符串 jewels 代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。
         stones 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
         字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
        示例 1：
                输入：jewels = "aA", stones = "aAAbbbb"
                输出：3
        示例 2：
                输入：jewels = "z", stones = "ZZ"
                输出：0
     */
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }

    // 方法一：
    public static int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for (char c : jewels.toCharArray())
            set.add(c);
        int res = 0;
        for (char c : stones.toCharArray()) {
            if (set.contains(c))
                res++;
        }
        return res;
    }

    // 方法二：
    public static int numJewelsInStones1(String jewels, String stones) {
        // ASCII 字符集
        int[] type = new int[256];
        for (char c : jewels.toCharArray())
            type[c] = 1;
        int res = 0;
        for (char c : stones.toCharArray())
            res += type[c];
        return res;
    }
}
