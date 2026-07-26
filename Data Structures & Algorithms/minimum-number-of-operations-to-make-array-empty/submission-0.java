class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int operations = 0;
        for (int count : map.values()) {
            if (count == 1) return -1;

            operations += (count + 2) / 3;
        }
        return operations;
    }
}