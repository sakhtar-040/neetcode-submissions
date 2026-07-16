class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int j : arr) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }

        int lucky = -1;
        for (int j : arr) {
            if (map.get(j) == j) {
                lucky = Math.max(lucky, map.get(j));
            }
        }

        return lucky;
    }
}