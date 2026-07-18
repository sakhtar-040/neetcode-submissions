class Solution {
    public int maxScore(String s) {
        int onesRight = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') onesRight++;
        }

        int zerosLeft = 0, best = 0;

        // split point must leave at least one char on right
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') zerosLeft++;
            else onesRight--;

            best = Math.max(best, zerosLeft + onesRight);
        }

        return best;
    }
}