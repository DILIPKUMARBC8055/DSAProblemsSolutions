class Solution {

    public int minimumMountainRemovals(int[] nums) {
        int[] leftToRight = new int[nums.length];
        int[] rightToleft = new int[nums.length];
        LIS(nums, leftToRight);
        LISrev(nums, rightToleft);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int newElement = leftToRight[i] + rightToleft[i] -1;
            if (leftToRight[i] > 1 && rightToleft[i] > 1) {
                max = Math.max(max, newElement);
            }
        }
        return nums.length - max;
    }

    private void LISrev(int[] nums, int[] dp) {
        Arrays.fill(dp, 1);
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
    }

    private void LIS(int[] nums, int[] dp) {
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
    }
}
