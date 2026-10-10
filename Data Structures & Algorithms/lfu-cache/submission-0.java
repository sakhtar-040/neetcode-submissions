class LFUCache {

    private static class Node {
        int key, value, freq;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    private static class DoublyList {
        Node head, tail;
        int size;

        DoublyList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size == 0) return null;
            Node last = tail.prev;
            remove(last);
            return last;
        }

        boolean isEmpty() {
            return size == 0;
        }
    }

    private final int capacity;
    private int size;
    private int minFreq;

    private final Map<Integer, Node> keyToNode;
    private final Map<Integer, DoublyList> freqToList;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 0;
        this.keyToNode = new HashMap<>();
        this.freqToList = new HashMap<>();
    }

    public int get(int key) {
        Node node = keyToNode.get(key);
        if (node == null) return -1;
        bumpFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        Node existing = keyToNode.get(key);
        if (existing != null) {
            existing.value = value;
            bumpFreq(existing);
            return;
        }

        if (size == capacity) {
            DoublyList minList = freqToList.get(minFreq);
            Node evict = minList.removeLast(); // LRU within minFreq
            keyToNode.remove(evict.key);
            size--;
        }

        Node node = new Node(key, value);
        keyToNode.put(key, node);
        freqToList.computeIfAbsent(1, f -> new DoublyList()).addFirst(node);
        minFreq = 1;
        size++;
    }

    private void bumpFreq(Node node) {
        int oldFreq = node.freq;
        DoublyList oldList = freqToList.get(oldFreq);
        oldList.remove(node);

        if (oldFreq == minFreq && oldList.isEmpty()) {
            minFreq++;
        }

        node.freq++;
        freqToList.computeIfAbsent(node.freq, f -> new DoublyList()).addFirst(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */