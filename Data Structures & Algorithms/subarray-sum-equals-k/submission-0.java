class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;

        int i = 0;
        while (i < nums.length ) {
            int j = i+1;
            if(nums[i] == k) {
                count++;
            }
            int sum = nums[i];
            while(j < nums.length) {
                sum =  sum + nums[j];
                if(sum == k) {
                    count++;
                }
                j++;
            }
            i++;
        }
        return count;
    }
}