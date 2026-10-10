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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            ListNode kthNode = getKthNode(prevGroupEnd, k);
            if (kthNode == null) break;

            ListNode nextGroupStart = kthNode.next;
            // Reverse the current group
            ListNode prev = kthNode.next;
            ListNode curr = prevGroupEnd.next;

            while (curr != nextGroupStart) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Connect the previous group with the reversed current group
            ListNode temp = prevGroupEnd.next; // This is the start of the current group before reversal
            prevGroupEnd.next = kthNode; // Connect to the new head of the reversed group
            prevGroupEnd = temp; // Move prevGroupEnd to the end of the reversed group
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode head, int k) {
        ListNode cur = head;
        for (int i = 0; i < k && cur != null; i++) {
            cur = cur.next;
        }
        return cur;
    }
}
