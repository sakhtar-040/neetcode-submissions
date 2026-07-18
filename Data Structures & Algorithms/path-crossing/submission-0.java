class Solution {
    public boolean isPathCrossing(String path) {
        Map<String, Boolean> map = new HashMap<>();
        map.put("0_0", true);
        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if(c == 'N') {
                y++;
            } else if(c == 'E') {
                x++;
            } else if(c == 'W') {
                x--;
            } else {
                y--;
            }
            String cor = x + "_" + y;
            if(map.containsKey(cor)) {
                return true;
            }
            map.put(cor, true);
        }

        return false;
    }
}