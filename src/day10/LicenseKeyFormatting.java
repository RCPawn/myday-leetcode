package day10;

public class LicenseKeyFormatting {
    /*
        给定一个许可密钥字符串 s，仅由字母、数字字符和破折号组成。
        字符串由 n 个破折号分成 n + 1 组。你也会得到一个整数 k 。
        我们想要重新格式化字符串 s，使每一组包含 k 个字符，
        除了第一组，它可以比 k 短，但仍然必须包含至少一个字符。
        此外，两组之间必须插入破折号，并且应该将所有小写字母转换为大写字母。
        返回 重新格式化的许可密钥 。
        示例 1：
                输入：S = "5F3Z-2e-9-w", k = 4
                输出："5F3Z-2E9W"
                解释：字符串 S 被分成了两个部分，每部分 4 个字符；
                     注意，两个额外的破折号需要删掉。
        示例 2：
                输入：S = "2-5g-3-J", k = 2
                输出："2-5G-3J"
                解释：字符串 S 被分成了 3 个部分，按照前面的规则描述，
                第一部分的字符可以少于给定的数量，其余部分皆为 2 个字符。
     */
    public static void main(String[] args) {
        String s = "5F3Z-2e-9-w";
        System.out.println(licenseKeyFormatting(s, 4));
    }

    public static String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.replace("-", "").toUpperCase());
        int i = sb.length() - k;
        while (i > 0) {
            sb.insert(i, "-");
            i -= k;
        }
        return sb.toString();
    }

    // 方法二：
    public static String licenseKeyFormatting1(String s, int k) {
        int cnt = 0;
        StringBuilder res = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '-') {
                cnt++;
                res.append(Character.toUpperCase(s.charAt(i)));
                if (cnt % k == 0)
                    res.append("-");
            }
        }
        if (res.length() > 0 && res.charAt(res.length() - 1) == '-')
            res.deleteCharAt(res.length() - 1);
        return res.reverse().toString();
    }
}
