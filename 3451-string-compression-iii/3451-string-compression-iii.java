class Solution {

    public String compressedString(String word) {
        StringBuilder str = new StringBuilder();
        int count = 0;
        char prev = word.charAt(0);
        for (char c : word.toCharArray()) {
            if (c == prev && count < 9) {
                count++;
            } else {
                str.append(count);
                str.append(prev);
                prev = c;
                count = 1;
            }
        }
        str.append(count);
        str.append(prev);
        return str.toString();
    }
}
