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
    public ListNode removeElements(ListNode head, int val) {
        ListNode tmp = new ListNode(-1);
        tmp.next = head;
        
        ListNode cur = head;
        ListNode prv = tmp;
        
        while (cur != null) {
            if (cur.val == val) {
                prv.next = cur.next;
            } else {
                prv = cur;
            }
            cur = cur.next;
        }
        
        return tmp.next;
    }
}