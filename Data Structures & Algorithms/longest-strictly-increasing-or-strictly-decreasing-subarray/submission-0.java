class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int strInc = 1;
        int inc = 1;
        int strDec = 1;
        int dec = 1;

        int i=0;
        int j=i+1;

        while(i<nums.length && j<nums.length) {
            if(nums[j] > nums[i]) {
                inc++;
            } else if(nums[i] >= nums[j]) {
                inc = 1;
            }
            strInc = Math.max(strInc, inc);
            i++;
            j++;
        }

        i=0;
        j=i+1;

        while(i<nums.length && j<nums.length) {
            if(nums[j] < nums[i]) {
                dec++;
            } else if(nums[i] <= nums[j]) {
                dec = 1;
            }
            strDec = Math.max(strDec, dec);
            i++;
            j++;
        }

        return Math.max(strInc, strDec);
    }
}