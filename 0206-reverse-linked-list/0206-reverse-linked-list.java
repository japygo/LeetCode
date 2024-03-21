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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode result = reverseList(head.next);
        head.next = null;

        ListNode tmp = result;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = head;

        return result;
    }
}