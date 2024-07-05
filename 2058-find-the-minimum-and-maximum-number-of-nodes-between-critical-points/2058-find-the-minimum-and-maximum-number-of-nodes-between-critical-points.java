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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> points = new ArrayList<>();
        int depth = 1;

        while (head.next != null && head.next.next != null) {
            if ((head.val < head.next.val && head.next.val > head.next.next.val) ||
                (head.val > head.next.val && head.next.val < head.next.next.val)) {
                points.add(depth + 1);
            }
            depth += 1;
            head = head.next;
        }

        if (points.size() < 2) {
            return new int[]{-1, -1};
        }

        int max = points.get(points.size() - 1) - points.get(0);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < points.size() - 1; i++) {
            min = Math.min(min, points.get(i + 1) - points.get(i));
        }

        return new int[]{min, max};
    }
}