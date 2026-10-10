class LRUCache {

    private static class Node {
        int key, value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1, -1); // dummy head
        this.tail = new Node(-1, -1); // dummy tail
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1; // key not found
        }
        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);

        if(node != null) {
            node.value = value;
            moveToFront(node);
            return;
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addToFront(newNode);

        if(map.size() > capacity) {
            Node lru = removeTail();
            map.remove(lru.key);
        }
    }

    public void moveToFront(Node node) {
        removeNode(node);
        addToFront(node);
    }

    public void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public  void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public Node removeTail() {
        Node lru = tail.prev;
        removeNode(lru);
        return lru;
    }
}
