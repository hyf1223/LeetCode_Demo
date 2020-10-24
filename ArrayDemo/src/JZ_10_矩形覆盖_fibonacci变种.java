/**
 * @author: heyifeng
 * @time: 2020/9/24 10:42
 * @description:我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
 * 
 */
public class JZ_10_矩形覆盖_fibonacci变种 {
    // 要覆盖 2*n 的大矩形，可以先覆盖 2*1 的矩形，再覆盖 2*(n-1) 的矩形；
    // 或者先覆盖 2*2 的矩形，再覆盖 2*(n-2) 的矩形。
    // 而覆盖 2*(n-1) 和 2*(n-2) 的矩形可以看成子问题。

    // 重点在于如何把大问题变成小问题
    public int RectCover(int n) {
        if (n <= 2) {
            return n;
        }
        int rec1 = 1;
        int rec2 = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = rec1 + rec2;
            rec1 = rec2;
            rec2 = result;
        }
        return result;
    }
    
}
