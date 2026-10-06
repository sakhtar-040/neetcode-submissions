/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // old node -> new node
        Map<Node, Node> map = new HashMap<>();

        // 1) Create all copied nodes
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // 2) Connect next and random pointers
        curr = head;
        while (curr != null) {
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);       // null-safe (map.get(null) = null)
            copy.random = map.get(curr.random);   // null-safe
            curr = curr.next;
        }

        return map.get(head);
    }
}
