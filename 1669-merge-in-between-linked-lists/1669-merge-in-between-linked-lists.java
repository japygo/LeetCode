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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode node = list1;
        ListNode aNode = null;
        ListNode bNode = null;
        while (node != null) {
            if (--a == 0) {
                aNode = node;
            }
            if (b-- == 0) {
                bNode = node.next;
            }
            node = node.next;
        }
        aNode.next = list2;

        node = list2;
        while (node.next != null) {
            node = node.next;
        }
        node.next = bNode;

        return list1;
    }
}