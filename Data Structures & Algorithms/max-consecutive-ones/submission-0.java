class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            }
            if (num == 0) {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(max, count);
    }
}