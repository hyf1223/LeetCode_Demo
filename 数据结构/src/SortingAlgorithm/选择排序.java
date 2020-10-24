package SortingAlgorithm;

import java.util.Arrays;

/**
 * @author: heyifeng
 * @time: 2020/9/19 16:57
 * @description:简单选择排序是选择排序的一种
 */
public class 选择排序 {
    public static void main(String[] args) {
        int[] arr = SortingUtils.randomArray(10, 100);
        System.out.println("产生的数组为:" + Arrays.toString(arr));
        System.out.println("简单选择排序结果为:" + Arrays.toString(selectionSorting(arr)));
    }

    // 简单选择排序是选择排序的一种
    private static int[] selectionSorting(int[] arr) {
        int length = arr.length;
        // 使用temp来进行元素交换
        // 使用minIndex来进行元素标记
        int temp, minIndex;
        for (int i = 0; i < length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < length; j++) {
                // 找到最小的位置
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 判断后交换
            if (minIndex != i) {
                temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }
}
