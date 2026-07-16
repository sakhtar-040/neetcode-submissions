class Solution {
    public boolean check(int[] nums) {
        int i=0;
        int j=i+1;
        while (i < nums.length && j < nums.length) {
            if (nums[i] <= nums[j]) {
                i++;
                j++;
            } else {

                break;
            }
        }

        if(j == nums.length) return true;

        int[] firstHalf = Arrays.copyOfRange(nums, 0, i+1);
        int[] secondHalf = Arrays.copyOfRange(nums, i+1, nums.length);

        int[] finalArray = new int[firstHalf.length + secondHalf.length];
        System.arraycopy(secondHalf, 0, finalArray, 0, secondHalf.length);
        System.arraycopy(firstHalf, 0, finalArray, secondHalf.length, firstHalf.length);

        i=0;
        j=i+1;

        while (i < finalArray.length && j < finalArray.length) {
            if (finalArray[i] > finalArray[j]) {
                return false;
            }
            i++;
            j++;
        }

        return true;
    }
}