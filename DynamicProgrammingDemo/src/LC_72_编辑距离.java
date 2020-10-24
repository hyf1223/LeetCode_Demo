import java.util.Scanner;

/**
 * @author: heyifeng
 * @time: 2020/10/6 19:55
 * @description:
 */
public class LC_72_编辑距离 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.nextLine();
        String word2 = sc.nextLine();

        LC_72_编辑距离 test = new LC_72_编辑距离();
        int res = test.minDistance(word1, word2);
        System.out.println("最少操作数:" + res);
    }

    public int minDistance(String word1, String word2) {
        // 输入校验
        /*
        空串是一个已经实例化之后的对象，是有内存空间的，
        只不过内存空间中存储的值为空。

        而null表示的是没有实例化的对象，不占内存空间。

        String aaa = "";//空串
        String bbb=null; //null值
        */
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 * len2 == 0) {
            return len1 + len2;
        }

        // 注意bp表格的样式,必须带上{0,0}
        int[][] bp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            bp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            bp[0][i] = i;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 如果 word1[i] 与 word2[j] 相等。第 i 个字符对应下标是 i-1
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    bp[i][j] = bp[i - 1][j - 1];
                } else {
                    bp[i][j] = Math.min(Math.min(bp[i - 1][j], bp[i][j - 1]), bp[i - 1][j - 1]) + 1;
                }
            }

        }
        return bp[len1][len2];
    }
}