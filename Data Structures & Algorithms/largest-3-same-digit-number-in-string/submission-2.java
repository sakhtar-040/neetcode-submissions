class Solution {
    public String largestGoodInteger(String num) {
        char best = 0;

        for (int i = 0; i + 2 < num.length(); i++) {
            char c = num.charAt(i);
            if (c == num.charAt(i + 1) && c == num.charAt(i + 2) && c > best) {
                best = c;
            }
        }

        return best == 0 ? "" : String.valueOf(best).repeat(3);
    }
}