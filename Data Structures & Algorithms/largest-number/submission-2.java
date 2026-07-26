class Solution {
    public String largestNumber(int[] nums) {
        String[] values = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            values[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(values, (a, b) -> (b + a).compareTo(a + b));

        if (values[0].equals("0")) return "0";

        StringBuilder result = new StringBuilder();
        for (String value : values) {
            result.append(value);
        }

        return result.toString();
    }
}