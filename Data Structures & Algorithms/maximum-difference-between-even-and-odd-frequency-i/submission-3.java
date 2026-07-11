class Solution {
    public int maxDifference(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0) minEven = Math.min(minEven, entry.getValue());
            else maxOdd = Math.max(maxOdd, entry.getValue());
        }
        return maxOdd - minEven;
    }
}