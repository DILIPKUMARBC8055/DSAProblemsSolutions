class Solution {
    int max;

    public int countMaxOrSubsets(int[] nums) {
        max=0;
        for(int i:nums)
        {
            max|=i;
        }
        return helper(nums,0,0);
    }

    private int helper(int[] nums, int index, int orNumber) {
        if (nums.length == index) {
            return orNumber == max ? 1 : 0;
        }
        return helper(nums, index + 1, nums[index] | orNumber) + helper(nums, index + 1, orNumber);
    }
}
