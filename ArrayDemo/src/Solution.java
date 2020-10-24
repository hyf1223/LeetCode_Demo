/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    public static void main(String[] args) {
        ListNode l11 = new ListNode(7);
        ListNode l12 = new ListNode(5);
        ListNode l13 = new ListNode(2);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(3);
        ListNode l22 = new ListNode(4);
        ListNode l23 = new ListNode(7);
        l21.next = l22;
        l22.next = l23;

        ListNode res = addTwoNumbers(l11,l21);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2;

        // 设置大于9的进位数carry
        int carry = 0 ;

        // 建立节点用来保存新的链表
        ListNode res = new ListNode(0) ;
        ListNode l = res;

        // p+q，空节点设置相加的value为0
        while (p!=null || q!=null) {
            int a = ( p != null ) ? p.val : 0 ;
            int b = ( q != null ) ? q.val : 0 ;
            int sum = carry + a + b ;
            carry = sum / 10 ;
            l.next = new ListNode(sum % 10) ;
            l = l.next;

            if ( p != null ) p = p.next;
            if ( q != null ) q = q.next;

        }

        // 判断最后数字是否进位产生新位
        if (carry > 0){
            l.next = new ListNode(carry);
        }

        return res.next;

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int num){
            val = num;
        };
    }
}