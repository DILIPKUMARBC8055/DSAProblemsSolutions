class Solution {

    public int minSwaps(String s) {
        int notBalance = 0;
        int max = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                notBalance--;
            } else {
                notBalance++;
            }
            max = Math.max(max, notBalance);
        }
        return (max + 1) / 2;
    }
}
