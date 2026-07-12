class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[]  res = new int[2];
        int repeated = 0;
        int missing = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(map.containsKey(grid[i][j])) {
                    repeated =  grid[i][j];
                }
                map.put(grid[i][j], map.getOrDefault(grid[i][j], 0) + 1);
            }
        }

        res[0] = repeated;

        for (int i = 1; i <= grid.length * grid[0].length; i++) {
            if (!map.containsKey(i)) {
                missing =  i;
                break;
            }
        }

        res[1] = missing;

        return res;
    }
}