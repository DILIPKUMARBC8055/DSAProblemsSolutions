class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean taken[] = new boolean[nums.length];
        List<Integer> holder = new ArrayList<>();
        helper(ans, nums, taken, holder);
        return ans;
    }

    public void helper(List<List<Integer>> ans,int[]nums,boolean taken[],List<Integer> holder)
    {
        if(holder.size()==nums.length)
        {
            ans.add(new ArrayList<>(holder));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
          if(!taken[i])  {
            taken[i]=true;
            holder.add(nums[i]);
            helper(ans,nums,taken,holder);
            taken[i]=false;
            holder.remove(holder.size()-1);}
        }
    }
}