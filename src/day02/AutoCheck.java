package day02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutoCheck {
    /*
        万万没想到之聪明的编辑
        我叫王大锤，是一家出版社的编辑。
        我发现一个发现拼写错误的捷径：

        1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
        2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
        3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC

        请实现大锤的自动校对程序
        示例
            输入例子：
                    2
                    helloo
                    wooooooow
            输出例子：
                    hello
                    woow
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            StringBuilder sb = new StringBuilder();
            String s = sc.nextLine();
            for (int j = 0; j < s.length(); j++) {
                int n = sb.length();
                // 如果目标字符串长度大于1，并且最后一个字符和当前字符相同时进行比较
                if (n > 1 && s.charAt(j) == sb.charAt(n - 1)) {
                    // 1.倒数第一个和倒数第二个相同（符合AAA）
                    // 2.倒数第二个和倒数第三个相同（符合AABB）
                    if ((sb.charAt(n - 1) == sb.charAt(n - 2))
                            || (n > 2 && sb.charAt(n - 2) == sb.charAt(n - 3))) {
                        continue;
                    }
                }
                sb.append(s.charAt(j));
            }
            list.add(sb.toString());
        }
        list.forEach(System.out::println);
        sc.close();
    }
}
