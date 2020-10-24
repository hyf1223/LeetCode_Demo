import java.util.Scanner;

/**
 * @author: heyifeng
 * @time: 2020/9/27 10:02
 * @description: 服装店新进了a条领带，b条裤子，c个帽子，d件衬衫，现在要把这些搭配起来售卖。有三种搭配方式，一条领带和一件衬衫，一条裤子和一件衬衫，一个帽子和一件衬衫。卖出一套领带加衬衫可以得到e元，卖出一套裤子加衬衫可以得到f元，卖出一套帽子加衬衫可以得到g元。现在你需要输出最大的获利方式。
 *
 * 一行7个整数，空格隔开，分别表示a,b,c,d,e,f,g。
 *
 * (1≤a,b,c,d,e,f,g≤1e5)
 *
 * 输出最大获利的值。
 */
public class TestMeituan1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        // a +d
        int e = sc.nextInt();
        // b+d
        int f = sc.nextInt();
        // c+d
        int g = sc.nextInt();

        int result = maxMoney(a, b, c, d, e, f, g);

    }

    private static int maxMoney(int a, int b, int c, int d, int e, int f, int g) {
        int sum = 0;
        if (e > f && e > g) {
            if (a >= d) {
                return d * e;
            } else {
                
            }
        }
        return 0;
    }

}
