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
    public int pairSum(ListNode head) {
        int maxSum = Integer.MIN_VALUE;
        ListNode dummy = head;
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;

        while (dummy != null) {
            map.put(index, dummy.val);
            dummy = dummy.next;
            index++;
        }
        int n = index;
        for (int i = 0; i < n / 2; i++) {
            int sum = map.get(i) + map.get(n - 1 - i);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}