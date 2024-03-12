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
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        ListNode dummy = new ListNode(0, head);
        ListNode node = new ListNode(0, head);
        while (node != null) {
            sum += node.val;
            map.put(sum, node);
            node = node.next;
        }
        sum = 0;
        node = dummy;
        while (node != null) {
            sum += node.val;
            node.next = map.get(sum).next;
            node = node.next;
        }
        return dummy.next;
    }
}