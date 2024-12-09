package day11;

public class CountCompleteDayPairs {
    /*
        给你一个整数数组 hours，表示以小时为单位的时间，
        返回一个整数，表示满足 i < j 且 hours[i] + hours[j] 构成 整天 的下标对 i, j 的数目。
        整天 定义为时间持续时间是 24 小时的整数倍。
        例如，1 天是 24 小时，2 天是 48 小时，3 天是 72 小时，以此类推。
        示例 1：
                输入： hours = [12,12,30,24,24]
                输出： 2
                解释：构成整天的下标对分别是 (0, 1) 和 (3, 4)。
        示例 2：
                输入： hours = [72,48,24,3]
                输出： 3
                解释：构成整天的下标对分别是 (0, 1)、(0, 2) 和 (1, 2)。
     */
    public static void main(String[] args) {
        int[] hours = {72, 48, 24, 3};
        System.out.println(countCompleteDayPairs(hours));
    }

    // 方法一：
    public static int countCompleteDayPairs(int[] hours) {
        int[] pos = new int[24];
        // 统计每个小时余数出现的次数
        for (int hour : hours)
            pos[hour % 24]++;
        int cnt = 0;
        // 计算符合条件的配对
        for (int hour : hours) {
            pos[hour % 24]--;  // 当前元素使用后减少计数
            int i = (24 - (hour % 24)) % 24;// 需要找的补数
            cnt += pos[i];  // 如果有该补数，增加组合数
        }
        return cnt;
    }

    // 方法二：
    public static int countCompleteDayPairs1(int[] hours) {
        int cnt = 0;
        for (int i = 1; i < hours.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((hours[i] + hours[j]) % 24 == 0)
                    cnt++;
            }
        }
        return cnt;
    }
}
