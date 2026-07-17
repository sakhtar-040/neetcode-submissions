class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] freq = new int[101]; // constraint: 1 <= nums[i] <= 100
        int pairs = 0;

        for (int num : nums) {
            pairs += freq[num];
            freq[num]++;
        }

        return pairs;
    }
}