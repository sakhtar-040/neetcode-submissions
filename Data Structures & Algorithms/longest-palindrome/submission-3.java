class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128]; // ASCII
    for (int i = 0; i < s.length(); i++) {
        freq[s.charAt(i)]++;
    }

    int len = 0;
    for (int c : freq) {
        len += (c / 2) * 2;
    }

    return (len < s.length()) ? len + 1 : len;
    }
}