class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        int[] need = new int[128];
        int i = 0;
        while (i < t.length()) {
            need[t.charAt(i)]++;
            i++;
        }

        int left = 0, right = 0;
        int required = t.length();
        int bestStart = 0, bestLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            char rc = s.charAt(right);

            if (need[rc] > 0) required--;
            need[rc]--;
            right++;

            while (required == 0) {
                if (right - left < bestLen) {
                    bestLen = right - left;
                    bestStart = left;
                }

                char lc = s.charAt(left);
                need[lc]++;
                if (need[lc] > 0) required++;
                left++;
            }
        }

        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
    }
}
