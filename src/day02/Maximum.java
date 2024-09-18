package day02;

public class Maximum {
    /*
        编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
        示例
            输入： a = 1, b = 2
            输出： 2
     */
    public static void main(String[] args) {
        System.out.println(maximum(2, 3));
    }

    public static int maximum(int a, int b) {
        long x = (long) a - (long) b;
        int k = (int) (x >> 63);
        return (1 + k) * a - b * k;
    }
}
