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
    Map<ListNode, Integer> map = new HashMap<>();
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        Integer val = map.get(head);
        if (val != null) {
            return true;
        }
        map.put(head, head.val);
        return hasCycle(head.next);
    }
}