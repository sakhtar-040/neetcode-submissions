class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            mapS.put(c, mapS.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : mapS.entrySet()) {
            if (!Objects.equals(mapT.get(entry.getKey()), entry.getValue())) {
                return false;
            }
        }

        return true;
    }
}
