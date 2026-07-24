class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            int count = entry.getValue();

            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }

            buckets[count].add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;

        for (int count = buckets.length - 1; count >= 1 && index < k; count--) {
            if (buckets[count] != null) {
                for (int num : buckets[count]) {
                    result[index++] = num;
                    if (index == k) break;
                }
            }
        }

        return result;
    }
}
