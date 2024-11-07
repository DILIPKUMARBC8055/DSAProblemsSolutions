class Solution {

    public int largestCombination(int[] candidates) {
        int n = candidates.length;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int freq = 0;
            for (int num : candidates) {
                int newNum = num & (1 << i);
                if (newNum == 1 << i) {
                    freq++;
                }
            }
            ans = Math.max(ans, freq);
        }
        return ans;
    }
}
