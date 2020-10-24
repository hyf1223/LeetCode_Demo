/**
 * @author: heyifeng
 * @time: 2020/9/24 20:23
 * @description: 老是写不对二分法?:https://blog.csdn.net/Px01Ih8/article/details/106232587
 */
public class JZ_6_旋转数组的最小数字 {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0)
            return 0;
        int l = 0, h = array.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            // 如果前中后都一样,则无法判断,需要顺序查找才行
            if (array[l] == array[m] && array[m] == array[h])
                return minNumber(array, l, h);

            else if (array[m] <= array[h])
                h = m;
            else
                l = m + 1;
        }
        return array[l];
    }

    // 特别的顺序查找:只要找到第一个小于n[i]的就行
    private int minNumber(int[] array, int l, int h) {
        for (int i = l; i < h; i++)
            if (array[i] > array[i + 1])
                return array[i + 1];
        return array[l];
    }

    // 写法2
    public int minNumberInRotateArray2(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }

        int index1 = 0;
        int index2 = array.length - 1;
        // 把indexMid初始化为index1的原因：
        // 一旦发现数组中第一个数字小于最后一个数字，表明该数组是排序的
        // 就可以直接返回第一个数字了
        int indexMid = index1;

        while (array[index1] >= array[index2]) {
            // 如果index1和index2指向相邻的两个数，
            // 则index1指向第一个递增子数组的最后一个数字，
            // index2指向第二个子数组的第一个数字，也就是数组中的最小数字
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }
            indexMid = (index1 + index2) / 2;
            // 特殊情况：如果下标为index1、index2和indexMid指向的三个数字相等，则只能顺序查找
            if (array[index1] == array[indexMid] && array[indexMid] == array[index2]) {
                return minNumber(array, index1, index2);
            }
            // 缩小查找范围
            if (array[indexMid] >= array[index1]) {
                index1 = indexMid;
            } else if (array[indexMid] <= array[index2]) {
                index2 = indexMid;
            }
        }

        return array[indexMid];
    }
    
}
