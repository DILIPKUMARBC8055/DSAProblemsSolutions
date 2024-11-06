class Solution {

    public boolean canSortArray(int[] nums) {
        int prevMax = Integer.MIN_VALUE;
        int currentMax = nums[0];
        int currentMin = nums[0];
        int currentBitCount = Integer.bitCount(nums[0]);
        int i = 0;
        int n = nums.length;
        while (i < n) {
            while (i < n && currentBitCount == Integer.bitCount(nums[i])) {
                currentMax = Math.max(currentMax, nums[i]);
                currentMin = Math.min(currentMin, nums[i]);
                i++;
            }
            if (prevMax > currentMin) return false;
            prevMax = currentMax;
            if (i == n) break;
            currentMin = nums[i];
            currentMax = nums[i];
            currentBitCount = Integer.bitCount(nums[i]);
        }
        return true;
    }
}
