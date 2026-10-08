class MyCircularQueue {

    private int k;
    private int[] deque;
    private int front;
    private int rear;
    private int size;

    public MyCircularQueue(int k) {
        this.k = k;
        deque = new int[k];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (size < k) {
            rear = (rear + 1) % k;
            deque[rear] = value;
            size++;
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if (size > 0) {
            front = (front + 1) % k;
            size--;
            return true;
        }
        return false;
    }

    public int Front() {
        if (size > 0) {
            return deque[front];
        }
        return -1;
    }

    public int Rear() {
        if (size > 0) {
            return deque[rear];
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == k;
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