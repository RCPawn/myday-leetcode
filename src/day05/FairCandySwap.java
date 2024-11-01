package day05;

import java.util.Arrays;
import java.util.HashSet;

public class FairCandySwap {
    /*
        爱丽丝和鲍勃拥有不同总数量的糖果。
        给你两个数组 aliceSizes 和 bobSizes ，
        aliceSizes[i] 是爱丽丝拥有的第 i 盒糖果中的糖果数量，
        bobSizes[j] 是鲍勃拥有的第 j 盒糖果中的糖果数量。
        两人想要互相交换一盒糖果，这样在交换之后，他们就可以拥有相同总数量的糖果。
        一个人拥有的糖果总数量是他们每盒糖果数量的总和。
        返回一个整数数组 answer，其中 answer[0] 是爱丽丝必须交换的糖果盒中的糖果的数目，
        answer[1] 是鲍勃必须交换的糖果盒中的糖果的数目。
        如果存在多个答案，你可以返回其中 任何一个 。
        题目测试用例保证存在与输入对应的答案。
        示例 1：
                输入：aliceSizes = [1,1], bobSizes = [2,2]
                输出：[1,2]
        示例 2：
                输入：aliceSizes = [1,2], bobSizes = [2,3]
                输出：[1,2]
        示例 3：
                输入：aliceSizes = [2], bobSizes = [1,3]
                输出：[2,3]
        示例 4：
                输入：aliceSizes = [1,2,5], bobSizes = [2,4]
                输出：[5,4]
     */
    public static void main(String[] args) {
        int[] aliceSizes = {1, 2, 5}, bobSizes = {2, 4};
        System.out.println(Arrays.toString(fairCandySwap(aliceSizes, bobSizes)));
    }

    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sum1 = Arrays.stream(aliceSizes).sum();
        int sum2 = Arrays.stream(bobSizes).sum();
    /*
        为了让两人交换后糖果总和相等，爱丽丝和鲍勃的交换糖果应满足：
        sum1 - aliceSize + bobSize == sum2 - bobSize + aliceSize。
        根据这个公式推导出：bobSize = aliceSize + (sum2 - sum1) / 2。
    */
        int delta = (sum2 - sum1) / 2;

        // 使用 HashSet 提高查找效率
        HashSet<Integer> set = new HashSet<>();
        for (int bobSize : bobSizes) {
            set.add(bobSize);
        }
        // 查找满足条件的交换对
        for (int alice : aliceSizes) {
            int bob = alice + delta;
            if (set.contains(bob))
                return new int[] { alice, bob };
        }
        return new int[0];
    }
}
