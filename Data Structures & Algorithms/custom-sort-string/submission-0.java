class Solution {
    public String customSortString(String order, String s) {
        int[] freq = new int[26];
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : order.toCharArray()) {
            int index = c - 'a';

            while (freq[index] > 0) {
                result.append(c);
                freq[index]--;
            }
        }

        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                result.append((char) ('a' + i));
                freq[i]--;
            }
        }

        return result.toString();
    }
}