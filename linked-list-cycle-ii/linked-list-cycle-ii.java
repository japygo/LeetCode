/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode node = head;
        Set<ListNode> set = new HashSet<>();
        set.add(head);
        while (node != null) {
            node = node.next;
            if (set.contains(node)) {
                return node;
            }
            set.add(node);
        }
        return null;
    }
}