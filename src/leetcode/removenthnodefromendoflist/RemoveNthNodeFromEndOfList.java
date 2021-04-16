package leetcode.removenthnodefromendoflist;

/**
 * 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 
 * 示例：
 * 
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 
 * 给定的 n 保证是有效的。
 * 
 * 进阶：你能尝试使用一趟扫描实现吗？
 * 
 * @author ASUS
 *
 */
public class RemoveNthNodeFromEndOfList {
	public static void main(String[] args) {
		ListNode list = new ListNode(1);
		list.next = new ListNode(2);
		list.next.next = new ListNode(3);
		list.next.next.next = new ListNode(4);
		list.next.next.next.next = new ListNode(5);
		int n = 2;
		Solution solution = new Solution();
		solution.removeNthFromEnd(list, n);
		
	}
}

//Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

class Solution {
   public ListNode removeNthFromEnd(ListNode head, int n) {
	   ListNode dummy = new ListNode(0); // dummy 假人，傀儡
	   dummy.next = head;
	   ListNode fast = dummy;
	   ListNode slow = dummy;
	   for (int i = 0; i < n; i++) {
		   fast = fast.next;
	   }
	   while (fast.next != null) {
		   fast = fast.next;
		   slow = slow.next;
	   }
	   slow.next = slow.next.next;
	   return dummy.next;
   }
}