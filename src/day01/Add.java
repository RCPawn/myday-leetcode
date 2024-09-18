package day01;

public class Add {
    /*
        设计一个函数把两个数字相加。
        不得使用 + 或者其他算术运算符。

        示例
            输入：a = 1, b = 1
            输出：2
     */
    public static void main(String[] args) {
        int res = add(7, 4);
        System.out.println(res);
    }

    public static int add(int a, int b) {
        /*
            &:
            1010 & 1100 = 1000
            <<:
            0010 << 2 = 1000
            ^:
            1010 ^ 1100 = 0110
         */
        // 循环直到没有进位为止
        while (b != 0) {
            // 计算进位：按位与操作找出需要进位的位，左移一位表示进位到下一位
            int carry = (a & b) << 1;
            // 计算没有进位的部分：按位异或操作得到不考虑进位的加法结果
            a = a ^ b;
            // 更新 b 为新的进位值
            b = carry;
        }
        // 当 b 为 0 时，a 中存储的就是两个数的和
        return a;
    }

}
