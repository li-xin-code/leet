package leetcode.addtownumbers;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public void out() {
        ListNode current = this;
        while (current != null) {
            System.out.print(current.val);
            current = current.next;
        }
    }

}
