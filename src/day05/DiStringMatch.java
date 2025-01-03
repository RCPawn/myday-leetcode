package day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiStringMatch {
    /*
        由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
        如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I'
        如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D'
        给定一个字符串 s ，重构排列 perm 并返回它。
        如果有多个有效排列perm，则返回其中 任何一个 。
        示例 1：
                输入：s = "IDID"
                输出：[0,4,1,3,2]
        示例 2：
                输入：s = "III"
                输出：[0,1,2,3]
        示例 3：
                输入：s = "DDI"
                输出：[3,2,0,1]
     */
    public static void main(String[] args) {
        String s = "IDID";
        System.out.println(Arrays.toString(diStringMatch(s)));
    }

    public static int[] diStringMatch(String s) {
        int n = s.length();
        int l = 0, r = n;
        int[] res = new int[r + 1];
        for (int i = 0; i < n; i++) {
            res[i] = s.charAt(i) == 'I' ? l++ : r--;
        }
        res[n] = l;
        return res;
    }
}
