class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for(int num: nums) {
            if(num < 0) {
                neg.add(num);
            } else {
                pos.add(num);
            }
        }

        int i=0;
        int index = 0;
        while(i<nums.length) {
            nums[i] = pos.get(index);
            nums[i+1] = neg.get(index);

            i = i + 2;
            index++;
        }

        return nums;
    }
}