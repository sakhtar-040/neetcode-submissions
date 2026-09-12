class Solution {
    public int compress(char[] chars) {
        int i=0;
        StringBuilder sb = new StringBuilder();
        while(i < chars.length) {
            int j = i+1;
            int count = 1;
            while(j < chars.length && chars[i] == chars[j]) {
                count++;
                j++;
            }
            sb.append(chars[i]);
            if(count != 1) {
                sb.append(count);
            }
            i = j;
        }

        for(i=0; i<sb.toString().length(); i++) {
            chars[i] = sb.charAt(i);
        }

        return sb.toString().length();
    }
}