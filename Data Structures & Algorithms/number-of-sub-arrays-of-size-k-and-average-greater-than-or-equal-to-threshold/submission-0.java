class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int sum = 0;

        int left = 0;
        int right = k-1;

        while(right < arr.length) {
            for(int i=left; i<=right; i++) {
                sum += arr[i];
            }
            if(sum/k >= threshold) {
                count++;
            }
            sum = 0;
            left++;
            right++;
        }
        return count;
    }
}