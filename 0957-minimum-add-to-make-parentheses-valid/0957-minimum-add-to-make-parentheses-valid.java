class Solution {

    public int minAddToMakeValid(String s) {
        Stack<Character> open = new Stack<>();
        Stack<Character> close = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open.push(c);
            } else {
                if (!open.isEmpty()) {
                    open.pop();
                } else {
                    close.push(c);
                }
            }
        }
        return close.size() + open.size();
    }
}
