class Solution {

    public char findKthBit(int n, int k) {
        StringBuilder str = new StringBuilder();
        helper(n, 1, str);
        return str.charAt(k-1);
    }

    private void helper(int n, int i, StringBuilder str) {
        if (i == n + 1) return;
        if (i == 1) {
            str.append("0");
            helper(n, i + 1, str);
        } else {
            String reverse = inverteString(new StringBuilder(str));
            str.append("1");
            str.append(reverse);
            helper(n, i + 1, str);
        }
    }

    private String inverteString(StringBuilder str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                str.setCharAt(i, '0');
            } else {
                str.setCharAt(i, '1');
            }
        }
        return str.reverse().toString();
    }
}
