class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // [value, index], max-heap by value
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});

            // remove elements outside current window [i-k+1 .. i]
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }

            if (i >= k - 1) {
                result[i - k + 1] = pq.peek()[0];
            }
        }

        return result;
    }
}
