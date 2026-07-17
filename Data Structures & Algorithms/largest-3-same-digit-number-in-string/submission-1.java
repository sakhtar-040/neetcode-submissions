class Solution {
    public String largestGoodInteger(String num) {
        int i=0;
        String res = "";
        int n = Integer.MIN_VALUE;;
        while(i < num.length()-1) {
            int j=1;
            while(j <= 2 && i + j < num.length()) {
                if(num.charAt(i) != num.charAt(i+j)) {
                    break;
                }
                j++;
                if(j > 2) {
                    n = Math.max(n, Integer.parseInt(num.substring(i, i+j)));
                }
            }
            i++;
        }

        if(n < 0) {
            return "";
        } else if (n == 0) {
            return "000";
        } else {
            return String.valueOf(n);
        }
    }
}