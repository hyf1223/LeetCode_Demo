package SortingAlgorithm;

import java.util.Arrays;

/**
 * @author: heyifeng
 * @time: 2020/9/18 16:46
 * @description:
 */
public class 冒泡排序 {
    public static void main(String[] args) {
        int[] arr = SortingUtils.randomArray(10, 100);
        System.out.println("原数组为:" + Arrays.toString(arr));
        System.out.println("冒泡排序为(从后往前,小数上浮):" + Arrays.toString(bubbleSorting(arr)));
        System.out.println("冒泡排序为(从前往后,大数下沉):" + Arrays.toString(bubbleSorting2(arr)));
    }

    public static int[] bubbleSorting(int[] arr) {
        int length = arr.length;
        boolean changeFlag = false;
        // 最多做length-1趟冒泡就能排好序
        for (int i = 0; i < length - 1; i++) {
            for (int j = length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    changeFlag = true;
                }
            }
            // 本次遍历之后没有发生交换,说明已经有序
            if (changeFlag == false) {
                return arr;
            }
        }
        return arr;
    }

    public static int[] bubbleSorting2(int[] arr) {
        int length = arr.length;
        boolean changeFlag = false;
        // 最多做length-1趟冒泡就能排好序
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    changeFlag = true;
                }
            }
            // 本次遍历之后没有发生交换,说明已经有序
            if (changeFlag == false) {
                return arr;
            }
        }
        return arr;
    }
}
