package day09;

public class ToGoatLatin {
    /*
        给你一个由若干单词组成的句子 sentence ，单词间由空格分隔。
        每个单词仅由大写和小写英文字母组成。
        请你将句子转换为 “山羊拉丁文（Goat Latin）”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。
        山羊拉丁文的规则如下：
        如果单词以元音开头（'a', 'e', 'i', 'o', 'u'），在单词后添加"ma"。
        例如，单词 "apple" 变为 "applema" 。
        如果单词以辅音字母开头（即，非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
        例如，单词 "goat" 变为 "oatgma" 。
        根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从 1 开始。
        例如，在第一个单词后添加 "a" ，在第二个单词后添加 "aa" ，以此类推。
        返回将 sentence 转换为山羊拉丁文后的句子。
        示例 1：
                输入：sentence = "I speak Goat Latin"
                输出："Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
        示例 2：
                输入：sentence = "The quick brown fox jumped over the lazy dog"
                输出："heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa
                hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
     */
    public static void main(String[] args) {
        String sentence = "The quick brown fox jumped over the lazy dog";
        System.out.println(toGoatLatin(sentence));
    }

    // 方法一：
    public static String toGoatLatin(String sentence) {
        String[] arr = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            // 对每个单词进行变换并拼接
            res.append(transform(arr[i], i + 1));
            if (i < arr.length - 1)
                res.append(" ");
        }
        return res.toString();
    }

    // 变换单词并按照索引添加字母a
    public static String transform(String word, int index) {
        String vowels = "aeiouAEIOU";
        // 判断是否以元音字母开头
        if (vowels.indexOf(word.charAt(0)) != -1)
            word += "ma";
        else
            word = word.substring(1) + word.charAt(0) + "ma";
        word += "a".repeat(index);
        return word;
    }

    // 判断单词是否以元音字母开头
    /*public static boolean startsWithVowel(String word) {
        Set<Character> vowels = new HashSet<>();
        char[] chs = {'a', 'e', 'i', 'o', 'u'};
        for (char ch : chs)
            vowels.add(ch);
        return vowels.contains(Character.toLowerCase(word.charAt(0)));
    }*/

    // 方法二：
    public static String toGoatLatin1(String sentence) {
        String[] words = sentence.split(" ");
        String vowels = "aeiouAEIOU";
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (vowels.indexOf(words[i].charAt(0)) == -1)
                words[i] = words[i].substring(1) + words[i].charAt(0);

            words[i] += "ma" + "a".repeat(i + 1);
            res.append(words[i]);
            if (i < words.length - 1)
                res.append(" ");
        }
        return res.toString();
    }
}