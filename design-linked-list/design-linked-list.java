class MyLinkedList {
    
    private Node head;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        
        Node node = head;
        while (index-- > 0) {
            node = node.next;
        }
        return node.val;
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        this.head = node;
        this.size++;
    }
    
    public void addAtTail(int val) {
        if (head == null) {
            this.head = new Node(val);
        } else {
            Node node = head;
            while(node.next != null) {
                node = node.next;
            }
            node.next = new Node(val);
        }
        this.size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        
        Node node = head;
        while (index-- > 1) {
            node = node.next;
        }
        Node newNode = new Node(val);
        newNode.next = node.next;
        node.next = newNode;
        this.size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node node = head;
            while (index-- > 1) {
                node = node.next;
            }
            node.next = node.next.next;
        }
        this.size--;
    }
    
    private class Node {
        private int val;
        private Node next;
        
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
        
        public Node(int val) {
            this(val, null);
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */