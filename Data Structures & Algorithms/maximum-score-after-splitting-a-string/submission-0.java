class Solution {
    public int maxScore(String s) {
        int i=1;
        int maxScore=0;
        while(i<s.length()) {
            String leftPart = s.substring(0, i);
            String rightPart = s.substring(i);

            int zeroes = 0;
            int once = 0;
            for(int j=0;j<leftPart.length();j++) {
                if(leftPart.charAt(j)=='0') zeroes++;
            }

            for(int j=0;j<rightPart.length();j++) {
                if(rightPart.charAt(j)=='1') once++;
            }

            maxScore = Math.max(maxScore, zeroes+once);

            i++;
        }

        return maxScore;
    }
}