class Solution {
    public int scoreOfString(String s) {
        char[] arr = s.toCharArray();
        int score = 0;
        int i = 0;
        while(i < arr.length-1) {
            score = score + Math.abs(((int) arr[i] - (int) arr[i+1]));
            i++;
        }
        return score;
    }
}