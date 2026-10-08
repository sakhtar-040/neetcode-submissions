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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 1) prev points to node before 'left'
        ListNode prev = dummy;
        int i = 1;
        while (i < left) {
            prev = prev.next;
            i++;
        }

        // 2) reverse [left..right]
        ListNode curr = prev.next;   // first node of sublist
        ListNode next = null;
        ListNode revPrev = null;
        int count = right - left + 1;

        while (count > 0) {
            next = curr.next;
            curr.next = revPrev;
            revPrev = curr;
            curr = next;
            count--;
        }

        // 3) reconnect
        ListNode sublistTail = prev.next; // old left node, now tail after reverse
        prev.next = revPrev;
        sublistTail.next = curr;

        return dummy.next;
    }
}