class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int windowSum = 0;
        int count = 0;

        // Build the first window.
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        // Avoid division: average >= threshold means sum >= threshold * k.
        if (windowSum >= threshold * k) {
            count++;
        }

        // Slide: add the entering value and remove the leaving value.
        for (int right = k; right < arr.length; right++) {
            windowSum += arr[right];
            windowSum -= arr[right - k];

            if (windowSum >= threshold * k) {
                count++;
            }
        }

        return count;
    }
}