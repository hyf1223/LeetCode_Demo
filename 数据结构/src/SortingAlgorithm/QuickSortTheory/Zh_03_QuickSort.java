package SortingAlgorithm.QuickSortTheory;

import java.util.Arrays;

/**
 * @author: heyifeng
 * @time: 2020/11/4 15:49
 * @description:
 */
public class Zh_03_QuickSort {
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partition = partition(arr, left, right);
            quickSort(arr, left, partition - 1);
            quickSort(arr, partition + 1, right);
        }
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            while (left < right && arr[right] > pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {// 注意小于等于
                left++;
            }
            swap(arr, left, right);
        }
        swap(arr, left, startIndex);
        return left;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 6, 1, 3, 7, 9, 8, 5};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

}
