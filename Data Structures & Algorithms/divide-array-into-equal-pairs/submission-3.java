class Solution {
    public boolean divideArray(int[] nums) {
        if(nums.length % 2 != 0) {
            return false;
        }

        int[] freq = new int[501];

        for (int num : nums) {
            freq[num]++;
        }

        for(int count : freq) {
            if((count & 1) != 0) {
                return false;
            }
        }

        return true;
    }
}