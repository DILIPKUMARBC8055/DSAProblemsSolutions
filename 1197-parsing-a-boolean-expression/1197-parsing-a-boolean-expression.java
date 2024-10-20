class Solution {

    public boolean parseBoolExpr(String expression) {
        Stack<Character> operation = new Stack<>();
        Stack<Character> values = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == '!' || c == '|' || c == '&') {
                operation.push(c);
            } else if (c == ')') {
                smallExpresssionEval(operation, values);
            } else {
                if (c != ',') values.push(c);
            }
        }
        return values.pop() == 't' ? true : false;
    }

    private void smallExpresssionEval(Stack<Character> operation, Stack<Character> values) {
        char op = operation.pop();
        if (op == '&') {
            boolean ans = true;
            while (values.peek() != '(') {
                boolean bool = values.pop() == 't' ? true : false;
                ans &= bool;
            }
            values.pop();
            values.push(ans ? 't' : 'f');
        } else if (op == '|') {
            boolean ans = false;
            while (values.peek() != '(') {
                boolean bool = values.pop() == 't' ? true : false;
                ans |= bool;
            }
            values.pop();
            values.push(ans ? 't' : 'f');
        } else {
            boolean ans = values.pop() != 't' ? true : false;
            while (values.peek() != '(') {
                boolean bool = values.pop() == 't' ? true : false;
                ans = !(bool);
            }
            values.pop();
            values.push(ans ? 't' : 'f');
        }
    }
}
