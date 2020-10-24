package SortingAlgorithm;

import java.util.Arrays;

/**
 * @author: heyifeng
 * @time: 2020/9/21 15:47
 * @description:
 */
public class 堆排序 {
    public static void main(String[] args) {
        int[] arr = SortingUtils.randomArray(10, 100);
        System.out.println("原数组为:" + Arrays.toString(arr));
        System.out.println("堆排序结果为:" + Arrays.toString(heapSorting(arr)));
    }

    private static int[] heapSorting(int[] arr) {
        int length = arr.length;
        // 构建大顶堆 i为第一个非叶子节点
        for (int i = length / 2 - 1; i >= 0; i--) {
            adjustMaxHeap(arr, i, length);

        }// 这里就不单独做成方法了.

        for (int j = length - 1; j >= 0; j--) {
            SortingUtils.swapArrayElem(arr, 0, j);
            adjustMaxHeap(arr, 0, j);
        }
        return arr;
    }

    private static void adjustMaxHeap(int[] arr, int index, int length) {
        // 先保存当前元素index
        int temp = arr[index];
        // 从index结点的左子结点开始，也就是2 * index + 1处开始
        for (int i = 2 * index + 1; i < length; i = 2 * i + 1) {
            // i指向子节点中的较大值(前提是子节点都存在)
            // 如果左子结点小于右子结点，i指向右子结点
            if (i + 1 < length && arr[i + 1] > arr[i]) {
                i += 1;
            }
            // 如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if (arr[i] > temp) {
                arr[index] = arr[i];
                index = i;
            } else {// 如果都没有根节点大,继续向下筛选
                break;
            }
            // 将temp值放到最终的位置
            arr[i] = temp;
        }
    }
}
