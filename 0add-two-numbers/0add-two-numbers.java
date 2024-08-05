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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1;
        
        int num = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + num;
            
            l1.val = sum % 10;
            num = sum / 10;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null && num != 0) {
            int sum = l1.val + num;
            
            l1.val = sum % 10;
            num = sum / 10;
            
            l1 = l1.next;
        }
        
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        
        while (l2 != null) {
            int sum = l2.val + num;
            
            l2.val = sum % 10;
            num = sum / 10;
            tail.next = l2;
            
            l2 = l2.next;
            tail = tail.next;
        }
        
        if (num > 0) {
            tail.next = new ListNode(num);
        }
        
        return head;
    }
}