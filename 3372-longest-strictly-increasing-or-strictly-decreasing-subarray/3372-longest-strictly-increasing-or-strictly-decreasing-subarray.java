class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int output=1;
        int inc=1,dec=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i-1]<nums[i]){
                inc++;
                dec=1;
            }else {
                inc=1;
            }

            if(nums[i-1]>nums[i]){
                dec++;
                inc=1;
            }else {
                dec=1;
            }
            output=Math.max(output,Math.max(inc,dec));

        }
        return output;
    }
}