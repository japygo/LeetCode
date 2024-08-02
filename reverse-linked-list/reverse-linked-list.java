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
        ListNode cur = head;
        ListNode prv = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prv;
            prv = cur;
            cur = tmp;
        }
        return prv;
    }
}