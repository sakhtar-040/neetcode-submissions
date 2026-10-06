class Node {
    int val;
    Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

class MyLinkedList {

    private Node head;
    public MyLinkedList() {
        this.head = new  Node(-1, null);
    }
    
   public int get(int index) {
        Node curr = head.next;
        for (int i = 0; i < index; i++) {
            if (curr == null) return -1;
            curr = curr.next;
        }
        return curr == null ? -1 : curr.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val, head.next);
        head.next = newNode;
    }

    public void addAtTail(int val) {
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node(val, null);
    }

    public void addAtIndex(int index, int val) {
        Node curr = head;
        for (int i = 0; i < index; i++) {
            if (curr == null) return;
            curr = curr.next;
        }
        if (curr == null) return;
        Node newNode = new Node(val, curr.next);
        curr.next = newNode;
    }

    public void deleteAtIndex(int index) {
        Node curr = head;
        for (int i = 0; i < index; i++) {
            if (curr == null) return;
            curr = curr.next;
        }
        if (curr == null || curr.next == null) return;
        curr.next = curr.next.next;
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