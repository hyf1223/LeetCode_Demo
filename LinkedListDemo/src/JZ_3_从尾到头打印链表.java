import javax.xml.bind.SchemaOutputResolver;
import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: heyifeng
 * @time: 2020/9/22 16:10
 * @description:
 */
public class JZ_3_从尾到头打印链表 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(10);
        ListNode node2 = new ListNode(20);
        ListNode node3 = new ListNode(30);
        ListNode node4 = new ListNode(40);
        ListNode node5 = new ListNode(50);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode list1 = node1;
        ListNode list2 = node1;
        ListNode list3 = node1;
        ListNode list4 = node1;

        ArrayList res1 = printListFromTailToHead_Recursion(list1);
        System.out.println("递归:"+res1.toString());
        System.out.println("--------");

        while (list2 != null) {
            System.out.print(list2.value + " ");
            list2 = list2.next;
        }// 证明list1的改变,不影响list2,但是刚创建的node之间的关系已经逆转了
        System.out.println("\n--------");

        System.out.println("栈:"+printListFromTailToHead_Stack(list4).toString());
        System.out.println("--------");

        // 头插法涉及到地址空间的变化
        System.out.println("头插:"+printListFromTailToHead_HeadInsert(list3).toString());

    }

    private static ArrayList<Integer> printListFromTailToHead_Stack(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.value);
            listNode = listNode.next;
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;

    }

    public static ArrayList<Integer> printListFromTailToHead_Recursion(ListNode listnode) {
        ArrayList<Integer> result = new ArrayList<>();
        // 小黄鸭法
        if (listnode != null) {
            // 递归调用
            // addAll是将ArrayList:result作为容器,实际返回的是listnode.value
            result.addAll(printListFromTailToHead_Recursion(listnode.next));
            result.add(listnode.value);
        }
        return result;
    }

    public static ArrayList<Integer> printListFromTailToHead_HeadInsert(ListNode listNode) {
        ListNode head = new ListNode(-1);
        while (listNode != null) {
            // 用p保存当前节点之后的部分
            ListNode p = listNode.next;
            // 头插法 操作当前节点
            listNode.next = head.next;
            head.next = listNode;
            // 再把listnode置为其后的一个节点
            listNode = p;
        }
        // 构建新链表
        ArrayList<Integer> result = new ArrayList<>();
        // 移除无value的头结点 即头结点编程一号节点
        head = head.next;
        while (head != null) {
            result.add(head.value);
            head = head.next;
        }
        return result;
    }
}

class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}
