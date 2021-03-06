package leetcode.mergetwosortedlists;

/**
 * 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author ASUS
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        Solution solution = new Solution();

        ListNode res = solution.mergeTwoLists(l1, l2);

        ListNode t = res;
        while (t != null) {
            System.out.print(t.val);
            if (t.next != null) System.out.print("->");
            t = t.next;
        }

    }

}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (l1 != null && l2 != null) {
            boolean chk = l1.val < l2.val;
            curr.next = chk ? l1 : l2;
            curr = curr.next;
            l1 = chk ? l1.next : l1;
            l2 = chk ? l2 : l2.next;
        }
        curr.next = l1 == null ? l2 : l1;
        return head.next;
    }
}