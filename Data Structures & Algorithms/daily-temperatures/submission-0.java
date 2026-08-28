class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int current = 0; current < temperatures.length; current++) {
            while (!stack.isEmpty()
                    && temperatures[current] > temperatures[stack.peek()]) {
                int previous = stack.pop();
                result[previous] = current - previous;
            }

            stack.push(current);
        }

        return result;
    }
}
