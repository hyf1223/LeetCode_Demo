package SortingAlgorithm.QuickSortTheory;

/**
 * @author: heyifeng
 * @time: 2020/11/4 20:22
 * @description:在一大堆数中求其前k大或前k小的问题，简称TOP-K问题。
 * 目前解决TOP-K问题最有效的算法是BFPRT算法，
 * 又称为中位数的中位数算法，
 * 该算法由Blum、Floyd、Pratt、Rivest、Tarjan提出，
 * 最坏时间复杂度为O(N)
 */
public class Zh_02_BFPRT {
        public int bfprt(int[] arr,int k){
            //1、对arr数组进行分组，每5个为一组
            //2、进行组内排序，时间复杂度为O(N)，取出每个组的中位数
            //3、每个组的中位数组成一个n/5的数组new_arr
            //4、递归bfprt(new_arr,new_arr.length/2)
            //5、得到一个中位数num
            return 0;
        }
        //利用这个中位数进行荷兰国旗算法，小于在左边，等于在中间，大于在右边
        //如果num==k,则该中位数就是第k大的数
        //如果num<k，则递归求num之后的数组
        //如果num>k，则递归求num之前的数组

}
