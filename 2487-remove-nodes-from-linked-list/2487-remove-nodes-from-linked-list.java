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
    public ListNode removeNodes(ListNode head) {
        return recur(head);
    }
    
    private ListNode recur(ListNode node) {
        if (node.next != null) {
            ListNode tmp = recur(node.next);

            if (node.val < tmp.val) {
                return tmp;
            }

            node.next = tmp;
        }

        return node;
    }
}