class Solution {
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private static int atMost(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, right = 0, result = 0, distinct = 0;

        while (right < nums.length) {
            int val = nums[right];
            freq.put(val, freq.getOrDefault(val, 0) + 1);
            if (freq.get(val) == 1) distinct++;
            right++;

            while (distinct > k) {
                int out = nums[left];
                freq.put(out, freq.get(out) - 1);
                if (freq.get(out) == 0) {
                    freq.remove(out);
                    distinct--;
                }
                left++;
            }

            result += right - left;
        }

        return result;
    }
}