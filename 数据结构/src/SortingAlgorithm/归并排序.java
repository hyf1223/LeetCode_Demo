package SortingAlgorithm;

import java.util.Arrays;

/**
 * @author: heyifeng
 * @time: 2020/10/30 17:17
 * @description:归并排序的时间复杂度为O(nlogn)
 */
public class 归并排序 {

    public static void main(String[] args) {
        int[] array = new int[]{19, 15, 37, 12, 25};
//        int[] array2 = new int[0];
        mergeSort(array);
        System.out.println(Arrays.toString(array));
//        System.out.println(Arrays.toString(array2));
    }

    public static void mergeSort(int[] array) {
        if (array == null || array.length <= 0) {
            return;
        }
        int len = array.length;
        int[] temp = new int[len];
        mergeSort(array, 0, len - 1, temp);
    }

    private static void mergeSort(int[] array, int first, int end, int[] temp) {
        if (first < end) {
            int mid = (first + end) / 2;
            mergeSort(array, first, mid, temp);
            mergeSort(array, mid + 1, end, temp);
            mergeArray(array, first, mid, end, temp);
        }

    }

    /*
     * 合并两个有序数组
     *
     * 构造比较奇特:
     * 第一个数组:array[first]~array[mid]
     * 第二个数组:array[mid+1]~array[end]
     * */
    private static void mergeArray(int[] array, int first, int mid, int end, int[] temp) {
        int i = first;
        int j = mid + 1;
        int k = 0;// 要注意k值最后会变成len,而array[len]越界

        while (i <= mid && j <= end) {
            if (array[i] <= array[j])
                temp[k++] = array[i++];
            else
                temp[k++] = array[j++];
        }

        while (j <= end) {
            temp[k++] = array[j++];
        }

        while (i <= mid) {
            temp[k++] = array[i++];
        }

        for (i = 0; i < k; i++) {
            array[first + i] = temp[i];
        }
    }

}
