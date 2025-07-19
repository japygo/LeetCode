class MyCircularQueue {
    private final int[] arr;
    private int front;
    private int rear;

    public MyCircularQueue(int k) {
        arr = new int[k];
        Arrays.fill(arr, -1);
        front = -1;
        rear = -1;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % arr.length;
        arr[rear] = value;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (front == rear) {
            front = -1;
            rear = -1;
            return true;
        }
        arr[front] = -1;
        front = (front + 1) % arr.length;
        return true;
    }
    
    public int Front() {
        if (front == -1) {
            return -1;
        }
        return arr[front];
    }
    
    public int Rear() {
        if (rear == -1) {
            return -1;
        }
        return arr[rear];
    }
    
    public boolean isEmpty() {
        return front == -1;
    }
    
    public boolean isFull() {
        return (front == 0 && rear == arr.length - 1) || (front == rear + 1);
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */