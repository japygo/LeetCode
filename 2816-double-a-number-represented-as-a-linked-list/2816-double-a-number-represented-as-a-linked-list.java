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
    public ListNode doubleIt(ListNode head) {
        ListNode node = head;
        ListNode prev = null;

        while (node != null) {
            node.val *= 2;

            if (prev != null && node.val >= 10) {
                node.val %= 10;
                prev.val += 1;
            }

            prev = node;
            node = node.next;
        }

        if (head.val >= 10) {
            head.val %= 10;
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }

        return head;
    }
}