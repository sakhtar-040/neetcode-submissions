class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        while(right < nums.length) {
            currentSum += nums[right];

            while(currentSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
            right++;
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}