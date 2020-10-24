/**
 * @author: heyifeng
 * @time: 2020/9/22 10:55
 * @description:
 */
public class JZ_2_替换空格 {
    public static String replaceSpace(StringBuffer str) {
        // 令 P1 指向字符串原来的末尾位置，
        // P2 指向字符串现在的末尾位置。
        // P1 和 P2 从后向前遍历，
        // 当 P1 遍历到一个空格时，
        // 就需要令 P2 指向的位置依次填充 02%（注意是逆序的），
        // 否则就填充上 P1 指向字符的值。
        // 从后向前遍是为了在改变 P2 所指向的内容时，
        // 不会影响到 P1 遍历原来字符串的内容。
        int p1 = str.length() - 1;
        for (int i = 0; i <= p1; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        int p2 = str.length() - 1;
        while (p1 >= 0 && p2 > p1) {
            char c = str.charAt(p1--);
            if (c == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            } else {
                str.setCharAt(p2--, c);
            }
        }
        return str.toString();
    }
}
