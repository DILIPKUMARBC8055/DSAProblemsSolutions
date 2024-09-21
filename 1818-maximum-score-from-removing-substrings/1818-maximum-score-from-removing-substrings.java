class Solution {
    int score;

    public int maximumGain(String s, int x, int y) {
        score = 0;

        if (x > y) {
            String remainingString = helper(s, x, 'a', 'b');
            helper(remainingString, y, 'b', 'a');
        } else {
            String remainingString = helper(s, y, 'b', 'a');
            helper(remainingString, x, 'a', 'b');
        }
        return score;
    }

    public String helper(String s, int points, char topChar, char bottomChar) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == topChar && c == bottomChar) {
                stack.pop();
                score += points;
            } else {
                stack.push(c);
            }
        }
        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }
}
