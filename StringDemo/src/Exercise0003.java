import java.util.HashMap;
import java.util.Scanner;

/**
 * 无重复字符的最长子串
 */
public class Exercise0003 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(new Scanner(System.in).nextLine()));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        HashMap<Character,Integer> hashMap = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                left = Math.max(left,hashMap.get(s.charAt(i))+1);
            }
            max = Math.max(max,i-left+1);
            hashMap.put(s.charAt(i),i);

        }
        return max;
    }

}
