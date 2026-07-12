class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if(pattern.length() != words.length) {
            return false;
        }

        Map<String, String> patternMap = new HashMap<>();

        for(int i=0; i<pattern.length(); i++) {
            if(patternMap.containsKey(Character.toString(pattern.charAt(i)))) {
                if(!patternMap.get(Character.toString(pattern.charAt(i))).equals(words[i])) {
                   return false;
                }
            } else if(patternMap.containsKey(words[i])) {
                if(!patternMap.get(words[i]).equals(Character.toString(pattern.charAt(i)))) {
                    return false;
                }
            } else {
                patternMap.put(Character.toString(pattern.charAt(i)), words[i]);
                patternMap.put(words[i], Character.toString(pattern.charAt(i)));
            }
        }

        return true;
    }
}