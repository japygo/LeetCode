/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node node = head;
        
        while (node != null) {
            if (node.child != null) {
                Node child = node.child;
                Node next = node.next;
                
                node.next = child;
                child.prev = node;
                node.child = null;
                
                while (child.next != null) {
                    child = child.next;
                }
                
                if (next != null) {
                    child.next = next;
                    next.prev = child;
                }
            }
            
            node = node.next;
        }
        
        return head;
    }
}