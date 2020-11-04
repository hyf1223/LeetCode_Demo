package SortingAlgorithm.QuickSortTheory;

import java.util.Arrays;

/**
 * @author: heyifeng
 * @time: 2020/11/4 19:52
 * @description: 荷兰国旗问题:
 * 给定一个数组arr和一个数num，
 * 请把小于num的数放在数组的左边，
 * 等于num的数放在数组的中间，
 * 大于num的数放在数组的右边。
 * 要求额外空间复杂度为O(1)，
 * 时间复杂度为O(N)
 *
 * 解决思路
 * 初始化less=-1，more=len(arr)，当前位置为cur=0。
 *
 * 如果arr[cur]<num，交换arr[cur]和arr[++less]的数，然后cur++
 * 如果arr[cur]>num，交换arr[cur]和arr[–-more]的数，然后cur不变
 * 如果当前位置上的数等于num，less和more均不变，cur++
 * 当cur==more时，停止比较，返回
 */
public class Zh_01_NetherlandsFlag {
    public static int[] partition(int[] arr, int L, int R, int num) {
        int i = L - 1;
        int j = R + 1;
        int cur = L;
        while (cur < j) {
            if (arr[cur] < num) {
                swap(arr, cur++, ++i);
            } else if (arr[cur] > num) {
                swap(arr, cur, --j);
            } else {
                cur++;
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 2, 9, 3, 5, 8, 8, 5, 1, 6, 6, 4};
        partition(arr, 0, arr.length - 1, 5);
        System.out.println(Arrays.toString(arr));
    }


}
