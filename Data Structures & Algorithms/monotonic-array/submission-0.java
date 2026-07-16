class Solution {
    public boolean isMonotonic(int[] nums) {
        int i = 0;
        int j=i+1;

        boolean isIncreasing = false;
        boolean isDecreasing = false;

        while (i < nums.length && j < nums.length) {
            if(nums[i] == nums[j]) {
                //
            } else if(nums[i] < nums[j]) {
                if(isDecreasing) {
                    return false;
                }
                isIncreasing = true;
            } else if(nums[i] > nums[j]) {
                if(isIncreasing) {
                    return false;
                }
                isDecreasing = true;
            }
            i++;
            j++;
        }

        return true;
    }
}