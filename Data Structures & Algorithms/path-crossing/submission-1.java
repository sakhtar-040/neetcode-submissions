class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> visited = new HashSet<>();
        visited.add("0_0");
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
            if(visited.contains(cor)) {
                return true;
            }
            visited.add(cor);
        }

        return false;
    }
}