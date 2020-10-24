/**
 * @author: heyifeng
 * @time: 2020/9/24 10:54
 * @description:
 */
public class JZ_8_跳台阶_fibonacci变种 {
    public int JumpFloor(int n) {
        if (n <= 2) {
            return n;
        }
        int jump1 = 1;
        int jump2 = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = jump1 + jump2;
            jump1 = jump2;
            jump2 = result;

        }
        return result;
    }

}
