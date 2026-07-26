class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean[] removed = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }  else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }  else {
                    removed[i] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            removed[stack.pop()] = true;
        }

        for (int i = 0; i < s.length(); i++) {
            if(!removed[i]) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}