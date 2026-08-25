class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String op : operations) {
            switch (op) {
                case "+":
                    int pop = stack.pop();
                    int add = pop + stack.peek();
                    stack.push(pop);
                    stack.push(add);
                    break;
                case "C":
                    stack.pop();
                    break;
                case "D":
                    int dob = stack.peek() * 2;
                    stack.push(dob);
                    break;
                default:
                    stack.push(Integer.parseInt(op));
                    break;
            }
        }

        int sum = 0;
        for (int score : stack) {
            sum += score;
        }
        return sum;
    }
}