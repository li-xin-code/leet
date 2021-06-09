package leetcode.swapnodesinpairs;

/**
 * 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * @author ASUS
 */
public class SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        Solution solution = new Solution();
        ListNode res = solution.swapPairs(head);
        ListNode c = res;
        while (c != null) {
            System.out.print(c.val);
            if (c.next != null) System.out.print("->");
            c = c.next;
        }
    }

}

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            swap(curr);
            curr = curr.next.next;
        }
        return dummy.next;
    }

    private void swap(ListNode pre) {
        ListNode dummy = pre.next;
        pre.next = dummy.next;
        dummy.next = dummy.next.next;
        pre.next.next = dummy;
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

