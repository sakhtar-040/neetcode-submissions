class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        int[] stack = new int[n];
        int top = -1;

        for (int asteroid : asteroids) {
            boolean destroyed = false;

            while (top >= 0 && asteroid < 0 && stack[top] > 0) {
                if (stack[top] < -asteroid) {
                    top--;
                } else if (stack[top] == -asteroid) {
                    top--;
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack[++top] = asteroid;
            }
        }

        int[] result = new int[top + 1];
        System.arraycopy(stack, 0, result, 0, top + 1);
        return result;
    }
}