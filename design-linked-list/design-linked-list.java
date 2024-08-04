class MyLinkedList {
    private Node head;
    private Node tail;
    private int size;
    
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        
        Node node = getNode(index);
        
        return node.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        } else {
            tail = newNode;
        }
        head = newNode;
        
        size++;
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
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
        
        Node prevNode = getNode(index - 1);
        Node newNode = new Node(val);
        Node nextNode = prevNode.next;
        
        newNode.prev = prevNode;
        newNode.next = nextNode;
        prevNode.next = newNode;
        if (nextNode != null) {
            nextNode.prev = newNode;
        }
        
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        
        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (index == size - 1) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
        } else {
            Node node = getNode(index);
            Node prevNode = node.prev;
            Node nextNode = node.next;
            
            if (prevNode != null) {
                prevNode.next = nextNode;
            }
            if (nextNode != null) {
                nextNode.prev = prevNode;
            }
        }
        
        size--;
    }
    
    private Node getNode(int index) {
        Node node;
        if (index < size / 2) {
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }
    
    private class Node {
        private int val;
        private Node next;
        private Node prev;
                
        public Node(int val) {
            this.val = val;
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