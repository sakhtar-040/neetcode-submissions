class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int[] freq = new int[10000];

        for (int num : nums) {
            freq[num]++;
        }

        for(int i=0; i<nums.length; i++) {
            if(freq[i+1] == 0) {
                res[1] = i+1;
            } else if(freq[i+1] == 2) {
                res[0] = i+1;
            }
        }

        return res;
    }
}