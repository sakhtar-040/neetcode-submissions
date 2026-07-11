class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        int pivot=0;
        while(pivot < nums.length) {
            int i=0;
            while(i < pivot) {
                leftSum = leftSum + nums[i];
                i++;
            }
            int j = pivot+1;
            while(j < nums.length) {
                rightSum = rightSum + nums[j];
                j++;
            }
            if(leftSum == rightSum) {
                return i;
            } else {
                leftSum = 0;
                rightSum = 0;
            }
            pivot++;
        }
        return -1;
    }
}