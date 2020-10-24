package SortingAlgorithm;

import java.util.Arrays;

/**
 * @author: heyifeng
 * @time: 2020/9/18 16:35
 * @description:
 */
public class SortingUtils {
    public static int[] randomArray(int length, int max) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max);

        }
        return arr;

    }

    public static int[] orderedArray(int length, int max) {
        int[] arr = randomArray(length, max);
        Arrays.sort(arr);
        return arr;
    }

    public static void swapArrayElem(int[] arr, int i, int j){
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

}
