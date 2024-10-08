class Solution {

    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int start = 0;
        int end = c.length - 1;
        while (start < end) {
            boolean first = isVowel(c[start]);
            boolean last = isVowel(c[end]);
            if (first && last) {
                char temp = c[start];
                c[start] = c[end];
                c[end] = temp;
                start++;
                end--;
            } else if (first) {
                end--;
            } else if (last) {
                start++;
            } else {
                start++;
                end--;
            }
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            str.append(c[i]);
        }
        return str.toString();
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
