package leetcode.weekly_contest_281.merge_nodes_in_between_zeros;

public class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode newHead = null;
        ListNode cur = null;
        int sumVal = 0;
        head = head.next;
        while (head != null) {
            if (head.val != 0) {
                sumVal += head.val;
            } else {
                if (newHead == null) {
                    newHead = new ListNode(sumVal);
                    cur = newHead;
                } else {
                    cur.next = new ListNode(sumVal);
                    cur = cur.next;
                }
                sumVal = 0;
            }
            head = head.next;
        }
        return newHead;
    }
}
