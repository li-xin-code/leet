package leetcode.mergeksortedlists;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * @author ASUS
 */
public class MergeKSortedLists {

    public static void main(String[] args) {

        ListNode[] lists = new ListNode[3];

        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        Solution solution = new Solution();
        ListNode res = solution.mergeKLists(lists);

        ListNode c = res;
        while (c != null) {
            System.out.print(c.val);
            if (c.next != null) System.out.print("->");
            c = c.next;
        }

    }

}

class Solution {
    class NodeComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }

    }

    // O(nklogk) ,O[k]
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        if (lists == null || lists.length == 0) return dummy.next;
        int size = lists.length;
        ListNode curr = dummy;
        NodeComparator comparator = new NodeComparator();
        PriorityQueue<ListNode> pQueue = new PriorityQueue<>(comparator);
        for (int i = 0; i < size; i++) {
            if (lists[i] != null) {
                pQueue.add(lists[i]);
            }
        }
        while (pQueue.size() != 0) {
            ListNode node = pQueue.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null) pQueue.add(node.next);
        }
        return dummy.next;
    }
}

// 还没看
class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        return process(lists, 0, lists.length - 1);
    }

    public ListNode process(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + ((right - left) >> 1);
        ListNode head1 = process(lists, left, mid);
        ListNode head2 = process(lists, mid + 1, right);
        return merge(head1, head2);
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        temp.next = head1 != null ? head1 : head2;
        return dummy.next;

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

