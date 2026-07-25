class Solution {
    public int[] productExceptSelf(int[] nums) {
        int i=0;
        int[] res = new int[nums.length];
        while(i <  nums.length) {
            int j=0;
            int mul = 1;
            while(j <  nums.length) {
                if(i != j) {
                    mul *= nums[j];
                }
                j++;
            }
            res[i] = mul;
            i++;
        }
        return res;
    }
}  
