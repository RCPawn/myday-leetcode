package day09;

public class DefangIPaddr {
    /*
        给你一个有效的 IPv4 地址 address，
        返回这个 IP 地址的无效化版本。
        所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
        示例 1：
                输入：address = "1.1.1.1"
                输出："1[.]1[.]1[.]1"
        示例 2：
                输入：address = "255.100.50.0"
                输出："255[.]100[.]50[.]0"
     */
    public static void main(String[] args) {
        System.out.println(defangIPaddr("255.100.50.0"));
    }

    // 方法一：
    public static String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    // 方法二：
    public static String defangIPaddr1(String address) {
        StringBuilder sb = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c == '.')
                sb.append("[.]");
            else
                sb.append(c);
        }
        return sb.toString();
    }
}
