class Solution {

    public String makeFancyString(String s) {
        char second = 'A';
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (stack.size() == 1) {
                second = stack.peek();
                stack.push(c);
            } else {
                if (!(second == stack.peek() && stack.peek() == c)) {
                    second = stack.peek();
                    stack.push(c);
                }
            }
        }
        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.append(stack.pop() + "");
        }
        return str.reverse().toString();
    }
}
