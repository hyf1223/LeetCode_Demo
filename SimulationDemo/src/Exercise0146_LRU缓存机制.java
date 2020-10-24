/**
 * @author: heyifeng
 * @time: 2020/8/10 16:48
 * @description: https://leetcode-cn.com/problems/lru-cache/
 * <p>
 * 要求在时间O(1)内完成put和get操作
 * 总结出 cache 这个数据结构必要的条件：查找快，插入快，删除快，有顺序之分。
 * 于是:
 * 哈希表查找快，但是数据无固定顺序；
 * 链表有顺序之分，插入删除快，但是查找慢。
 * 所以结合一下，形成一种新的数据结构：哈希链表。
 * 引:https://leetcode-cn.com/problems/lru-cache/solution/lru-ce-lue-xiang-jie-he-shi-xian-by-labuladong/
 * <p>
 * LRU 缓存算法的核心数据结构就是哈希链表，双向链表和哈希表的结合体。
 */
public class Exercise0146_LRU缓存机制 {
    // 写出双链表节点
    class Node {
        public int key, val;
        public Node next, prev;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    class doubleList {
        // 在链表头部添加节点x,时间O(1)
        public void addFirst(Node x){
            
        }

        // 删除链表中的节点x
        // 由于是双链表且给的是目标Node节点,时间O(1)
        public void remove(Node x){
            
        }

        // 删除链表中最后一个节点,并返回该节点,时间O(1)
        public Node removeLast(){

            return null;
        }

        // 返回链表长度,时间O(1)
        public int size(){

            return 0;
        }



    }

    public static void main(String[] args) {
        String message = "";
    }

    class LRUCache {

        public LRUCache(int capacity) {


        }

        public int get(int key) {
            return -1;
        }

        public void put(int key, int value) {
            return;
        }
    }


}
