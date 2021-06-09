package leetcode.removenodesink_group;

import java.util.Stack;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明：
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * @author ASUS
 */
public class RemoveNodesInK_Group {

    public static void main(String[] args) {

    }
}

class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre != null) {
            pre = reverse(pre, k);
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode pre, int k) {
        ListNode last = pre;
        for (int i = 0; i < k + 1; i++) {
            last = last.next;
            if (i != k && last == null) return null;
        }
        ListNode tail = pre.next; // 尾巴
        ListNode curr = pre.next.next;
        while (curr != last) {
            ListNode next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            tail.next = next;
            curr = next;
        }
        return tail;
    }

//    public ListNode reverseKGroup(ListNode head, int k) {
//    	if (head == null) return null;
//    	Stack<ListNode> stack = new Stack<ListNode>();
//    	ListNode dummy = new ListNode(0);
//    	dummy.next = head;
//    	ListNode curr = dummy;
//    	ListNode next = dummy.next;
//    	while (next != null) {
//			for (int i = 0; i < k && next != null; i++) {
//				stack.push(next);
//				next = next.next;
//			}
//			if (stack.size() != k) return dummy.next;
//			while (stack.size() != 0) {
//				curr.next = stack.pop();
//				curr = curr.next;
//			}
//			curr.next = next;
//		}
//    	return dummy.next;
//    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

