/**
 * @author: heyifeng
 * @time: 2020/8/9 14:56
 * @description:https://leetcode-cn.com/problems/gas-station/
 */
public class Exercise0134_加油站 {
    public static void main(String[] args) {
        int[] gas = new int[]{5, 1, 2, 3, 4};
        int[] cost = new int[]{4, 4, 1, 5, 1};
        System.out.println(canCompleteCircuit(gas, cost));
        System.out.println(canCompleteCircuit3(gas, cost));

    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int gasAll = 0, costAll = 0, length = gas.length;
        for (int i = 0; i < length; i++) {
            gasAll += gas[i];
        }
        for (int i = 0; i < length; i++) {
            costAll += cost[i];
        }
        if (gasAll < costAll) {
            return -1;
        }
        for (int i = 0; i < length; i++) {
            gasAll = 0;
            costAll = 0;
            if (gas[i] >= cost[i]) {
                int k = i;
                for (int j = 0; j < length; j++) {
                    gasAll += gas[k % length];
                    costAll += cost[k % length];
                    if (gasAll < costAll) {
                        break;
                    } else {
                        k++;
                    }
                }
                if (k == i + length) {
                    return i;
                }
            }
        }
        return -1;
    }

    //方法2:https://leetcode-cn.com/problems/gas-station/solution/gao-xiao-yi-ci-bian-li-si-lu-tong-su-bu-yong-fan-z/
    public static int canCompleteCircuit2(int[] gas, int[] cost) {
        int totalCost = 0, startIndex = 0, startToCurrentCost = 0;
        for (int i = 0; i < gas.length; i++) {
            //tmpCost表示从当前加油站到达下一个加油站至少需要汽车已有油多少升
            int tmpCost = cost[i] - gas[i];
            totalCost += tmpCost;
            startToCurrentCost += tmpCost;

            //如果该值大于零，则重置始发站为下一站点，重置startToCurrentCost为0
            if (startToCurrentCost > 0) {
                startIndex = i + 1;
                startToCurrentCost = 0;
            }
        }
        if (totalCost <= 0)
            return startIndex;
        else
            return -1;
    }

    /**
     * 当以tmpCost<=0的点开头并扫描了一定长度到达i后发现startToCurrentCost[startIndex,i]>0，
     * 而对于[startIndex,i）区间中任何一点j，
     * 由于都有startToCurrentCost[startIndex,j]<=0，
     * 则找不到任意一个j为新的startIndex使得startToCurrentCost[j,i]<=0。
     * 所以把startIndex重置为i+1。
     *
     * @param gas
     * @param cost
     * @return
     */
    public static int canCompleteCircuit3(int[] gas, int[] cost) {
        int currentGas = 0, gasAll = 0, index = 0, length = gas.length;
        for (int i = 0; i < length; i++) {
            int tmp = gas[i] - cost[i];
            currentGas += tmp;
            gasAll += tmp;
            if (currentGas < 0) {
                index = i + 1;
                currentGas = 0;
            }
        }
        if (gasAll >= 0) {
            return index;
        } else return -1;
    }

}
