/**
 * @author: heyifeng
 * @time: 2020/9/26 16:08
 * @description: https://leetcode-cn.com/problems/longest-palindromic-substring/solution/
 */
public class LC_5_最长回文子串 {
    // 暴力求解
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int begin = 0;
        int maxLen = 1;

        // s.charAt(i) 每次都会检查数组下标越界，因此先转换成字符数组
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && vaildPalindrome(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        // java的substring方法:beginIndex包括,endIndex不包括
        // 因此这里的begin+maxlen不用-1
        return s.substring(begin, begin + maxLen);
    }

    // 动态规划:注意填表顺序,要保证无后效性
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int begin = 0;
        int maxLen = 1;

        // s.charAt(i) 每次都会检查数组下标越界，因此先转换成字符数组
        char[] charArray = s.toCharArray();

        // dp[i][j]用来保存字串s[i...j]是否为回文
        boolean[][] dp = new boolean[len][len];

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (i - j < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // dp[i][j]为回文串,并且其长度大于之前记录的最大长度 才记录
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }

            }

        }
        return s.substring(begin,begin+maxLen);

    }

    // 判断输入的字符数组指定区间内是否为回文
    private boolean vaildPalindrome(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
