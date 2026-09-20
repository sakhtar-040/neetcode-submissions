class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        long windowSum = 0;
        int left = 0;
        int best = 1;

        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];

            // Cost to make all elements in [left..right] equal nums[right]
            while ((long) nums[right] * (right - left + 1) - windowSum > k) {
                windowSum -= nums[left];
                left++;
            }

            best = Math.max(best, right - left + 1);
        }

        return best;
    }
}