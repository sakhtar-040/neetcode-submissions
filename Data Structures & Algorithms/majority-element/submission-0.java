class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int threshold = nums.length / 2;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        System.out.println(map);

        int majorityElement = 0;
        for (int num : map.keySet()) {
            if (map.containsKey(num)) {
                if (map.get(num) > threshold) {
                    majorityElement = num;
                }
            }
        }

        return majorityElement;
    }
}