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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode(0, head);
        ListNode first = root;
        ListNode last = root;

        for (int i = 0; i < n; i++) {
            last = last.next;
        }
        
        while (last.next != null) {
            first = first.next;
            last = last.next;
        }
        
        first.next = first.next.next;

        return root.next;
    }
}