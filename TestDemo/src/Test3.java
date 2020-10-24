import java.text.DateFormatSymbols;
import java.util.*;

/**
 * @author: heyifeng
 * @time: 2020/9/26 20:18
 * @description:
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        Scanner sc2 = new Scanner(System.in);
        char[][] matrix = new char[n][m];

        HashMap map = new HashMap<HashMap<Integer,Integer>,Integer>();
        for (int i = 0; i < n; i++) {
            String s = sc2.next();
            char[] chars = s.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                matrix[i][j] = chars[j];
            }
        }

        int start = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 'X'){
                    start ++;
                    map.put(new HashMap<>(i,j),0);
                }
            }
        }

        dfs(matrix,map);
    }

    private static void dfs(char[][] matrix, HashMap map) {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            
        }

    }
}
