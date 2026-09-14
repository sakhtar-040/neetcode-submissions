class Solution {
    public int minimumRecolors(String blocks, int k) {
        int whiteCount = 0;

        // Build the first window [0, k - 1].
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
        }

        int minimum = whiteCount;

        // Add blocks[right] and remove blocks[right - k].
        for (int right = k; right < blocks.length(); right++) {
            if (blocks.charAt(right - k) == 'W') {
                whiteCount--;
            }

            if (blocks.charAt(right) == 'W') {
                whiteCount++;
            }

            minimum = Math.min(minimum, whiteCount);
        }

        return minimum;
    }
}