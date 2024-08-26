package day01;

public class CompressString {
    public static void main(String[] args) {
        String s = "aabcccccaaa";
        System.out.println(compressString(s));
    }

    public static String compressString(String S) {
        int n = S.length();
        if (n == 0)
            return S;
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char c = S.charAt(0);
        for (int i = 1; i < n; i++) {
            if (c == S.charAt(i)) {
                count++;
            } else {
                sb.append(c);
                sb.append(count);
                c = S.charAt(i);
                count = 1;
            }
        }
        sb.append(c);
        sb.append(count);
        return sb.length() >= n ? S : sb.toString();
    }
}
