class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int length = 0;
        boolean hasOdd = false;

        for (int count : map.values()) {
            length += (count / 2) * 2; // add largest even part
            if ((count % 2) == 1) hasOdd = true;
        }

        return hasOdd ? length + 1 : length;
    }
}