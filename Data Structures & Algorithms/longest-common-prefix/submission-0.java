class Solution {
    public String longestCommonPrefix(String[] strs) {
        String str = "";
        String first = strs[0];
        char[] chars = first.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String tempStr = str + chars[i];
            for(int j = 1; j < strs.length; j++) {
                if(!strs[j].startsWith(tempStr)) {
                    return str;
                }
            }
            str = tempStr;
        }
        return str;
    }
}