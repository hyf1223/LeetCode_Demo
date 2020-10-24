/**
 * @author: heyifeng
 * @time: 2020/9/24 10:15
 * @description:
 */
public class JZ_7_斐波那契数列 {
    // 1.如果使用递归求解，会重复计算一些子问题。
    // 2.递归是将一个问题划分成多个子问题求解，动态规划也是如此，但是动态规划会把子问题的解缓存起来，从而避免重复求解子问题
    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        // 注意n从0开始,当n=39时数组中有40个数字
        int[] fib = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 2] + fib[i - 1];
        }
        return fib[n];
    }

    // 3.考虑到第 i 项只与第 i-1 和第 i-2 项有关，因此只需要存储前两项的值就能求解第 i 项，从而将空间复杂度由 O(N) 降低为 O(1)。
    public int fibonacci2(int n) {
        if (n <= 1) {
            return n;
        }
        int fib1 = 0;
        int fib2 = 1;
        int fib = 0;
        for (int i = 2; i < n; i++) {
            fib = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib;
        }
        return fib;
    }

    // 接着想
    // 4.由于待求解的 n 小于 40，因此可以将前 40 项的结果先进行计算，之后就能以 O(1) 时间复杂度得到第 n 项的值。
    private int[] fib = new int[40];
    public JZ_7_斐波那契数列() {
        this.fib[1] = 1;
        for (int i = 2; i < this.fib.length; i++) {
            this.fib[i] = this.fib[i - 2] + this.fib[i - 1];
        }
    }
    public int Fibonacci(int n) {
        return fib[n];
    }
}
