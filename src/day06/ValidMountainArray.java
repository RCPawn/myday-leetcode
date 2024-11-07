package day06;

public class ValidMountainArray {
    /*
        给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。
        让我们回顾一下，如果 arr 满足下述条件，那么它是一个山脉数组：
        arr.length >= 3
        在 0 < i < arr.length - 1 条件下，存在 i 使得：
        arr[0] < arr[1] < ... arr[i-1] < arr[i]
        arr[i] > arr[i+1] > ... > arr[arr.length - 1]
        示例 1：
                输入：arr = [2,1]
                输出：false
        示例 2：
                输入：arr = [3,5,5]
                输出：false
        示例 3：
                输入：arr = [6,7,7,8,6]
                输出：false
     */
    public static void main(String[] args) {
        int[] arr = {6, 7, 7, 8, 6};
        System.out.println(validMountainArray(arr));
    }

    // 方法一：
    public static boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3)
            return false;
        int i = 0;
        while (i < n - 1 && arr[i] < arr[i + 1]) {
            i++;
        }
        if (i == 0 || i == n - 1)
            return false;
        while (i < n - 1 && arr[i] > arr[i + 1]) {
            i++;
        }
        return i == n - 1;
    }

    // 方法二：
    public static boolean validMountainArray1(int[] arr) {
        int n = arr.length;
        if (n < 3)
            return false;
        boolean hasPeak = false;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1])
                return false;
            if (arr[i] < arr[i - 1]) {
                if (i == 1)
                    return false;
                hasPeak = true;
            }
            else if (hasPeak) {
                return false;
            }
        }
        return hasPeak;
    }
}
