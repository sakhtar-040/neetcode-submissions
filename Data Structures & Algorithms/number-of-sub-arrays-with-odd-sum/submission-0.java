class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;

        long result = 0;
        int prefixSum = 0;
        int evenCount = 1; // empty prefix
        int oddCount = 0;

        for (int num : arr) {
            prefixSum += num;

            if (prefixSum % 2 == 0) {
                result += oddCount;
                evenCount++;
            } else {
                result += evenCount;
                oddCount++;
            }

            result %= MOD;
        }

        return (int) result;
    }
}