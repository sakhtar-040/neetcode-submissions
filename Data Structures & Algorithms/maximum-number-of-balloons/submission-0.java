class Solution {
    public int maxNumberOfBalloons(String text) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Character[] balloon = {'b', 'a', 'l', 'l', 'o', 'o', 'n'};
        for (int i = 0; i < text.length(); i++) {
            if(Arrays.asList(balloon).contains(text.charAt(i))) {
                map.put(text.charAt(i), map.getOrDefault(text.charAt(i), 0) + 1);
            }
        }

        while(true) {
            int i=0;
            while(i<balloon.length) {
                if(map.containsKey(balloon[i]) && map.get(balloon[i]) > 0) {
                    map.put(balloon[i], map.getOrDefault(balloon[i], 0) - 1);
                    i++;
                } else {
                    return count;
                }
            }
            count++;
        }
    }
}