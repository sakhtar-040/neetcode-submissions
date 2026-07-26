class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int i=0;
        while(i < nums.length) {
            int sum = nums[i];
            int j = i+1;
            while(j < nums.length) {
                sum = sum + nums[j];
                if(sum % k == 0) {
                    return true;
                }
                j++;
            }
            i++;
        }
        return false;
    }
}