class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int product = 1;
        int count = 0;

        while(right < nums.length) {
            product *= nums[right++];

            while(product >= k && left < right) {
                product /= nums[left++];
            }
            count += right - left;
        }
        return count;
    }
}