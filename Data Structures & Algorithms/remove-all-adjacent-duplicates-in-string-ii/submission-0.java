class Solution {
    public static String removeDuplicates(String s, int k) {
        Deque<Pair> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peekLast().ch == c) {
                stack.peekLast().count++;
            } else {
                stack.addLast(new Pair(c, 1));
            }

            if (stack.peekLast().count == k) {
                stack.removeLast();
            }
        }

        StringBuilder result = new StringBuilder();
        for (Pair pair : stack) {
            result.append(String.valueOf(pair.ch).repeat(pair.count));
        }

        return result.toString();
    }

    private static class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}