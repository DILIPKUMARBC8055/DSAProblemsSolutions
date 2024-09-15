class Solution {
    public int longestSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        int maxLength = Integer.MIN_VALUE;
        for (int i : nums) {
            if (max < i) {
                max = i;
                count = 1;
                maxLength = 1;

            } else if (max == i) {
                count++;
                maxLength = Math.max(maxLength, count);
            } else {
                count = 0;
            }
        }
        return maxLength;
    }
}