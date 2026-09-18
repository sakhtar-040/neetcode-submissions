class Solution {
    public int lengthOfLongestSubstring(String s) {
        int count  = 0;
        int left = 0;
        int right = 0;
        int n = s.length();
        int[] freq = new int[256];
        while (right < n) {
            char c = s.charAt(right);
            freq[c]++;
            while (freq[c] > 1) {
                char leftChar = s.charAt(left);
                freq[leftChar]--;
                left++;
            }
            count = Math.max(count, right - left + 1);
            right++;
        }
        return  count;
    }
}
