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
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == topChar && c == bottomChar) {
                sb.deleteCharAt(sb.length() - 1);  // Pop the last element
                score += points;
            } else {
                sb.append(c);  // Push current character
            }
        }
        return sb.toString();  // Return remaining string without needing reverse
    }
}
