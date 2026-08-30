class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new java.util.ArrayDeque<>();
        int number = 0;
        char operator = '+';

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (Character.isDigit(current)) {
                number = number * 10 + (current - '0');
            }

            if ((!Character.isDigit(current) && current != ' ')
                    || i == s.length() - 1) {
                switch (operator) {
                    case '+' -> stack.push(number);
                    case '-' -> stack.push(-number);
                    case '*' -> stack.push(stack.pop() * number);
                    case '/' -> stack.push(stack.pop() / number);
                }

                operator = current;
                number = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) result += stack.pop();
        return result;
    }
}