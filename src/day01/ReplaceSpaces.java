package day01;

public class ReplaceSpaces {
    public static void main(String[] args) {
        String S = "Mr John Smith    ";
        System.out.println(replaceSpaces(S, 13));
    }

    /*public static String replaceSpaces(String S, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (c == ' ')
                sb.append("%20");
            else
                sb.append(c);
        }
        return sb.toString();
    }*/

    public static String replaceSpaces(String S, int length) {
        return S.substring(0, length).replaceAll(" ", "%20");
    }
}
