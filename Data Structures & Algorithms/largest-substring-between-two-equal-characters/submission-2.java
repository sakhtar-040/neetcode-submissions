class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int i=0;
        int maxLength=Integer.MIN_VALUE;

        while(i < s.length()) {
            int j = i + 1;
            while(j < s.length()) {
                if(s.charAt(i) == s.charAt(j)) {
                    maxLength = Math.max(maxLength, j - i - 1);
                }
                j++;
            }
            i++;
        }

        return Math.max(maxLength, -1);
    }
}