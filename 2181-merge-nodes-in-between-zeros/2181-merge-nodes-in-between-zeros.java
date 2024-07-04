/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode tmp = result;
        ListNode cur = head.next;
        int sum = 0;

        while (cur != null) {
            if (cur.val != 0) {
                sum += cur.val;
            } else {
                tmp.next = new ListNode(sum);
                tmp = tmp.next;
                sum = 0;
            }

            cur = cur.next;
        }

        return result.next;
    }
}