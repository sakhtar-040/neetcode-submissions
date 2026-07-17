class Solution {
    public int numIdenticalPairs(int[] nums) {
        int i=0;
        int count = 0;

        while(i < nums.length) {
            int j = i + 1;
            while(j < nums.length) {
                if(nums[i] == nums[j]) {
                    count++;
                }
                j++;
            }
            i++;
        }

        return count;
    }
}