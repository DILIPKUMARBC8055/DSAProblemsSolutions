class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean taken[] = new boolean[nums.length];
        List<Integer> holder = new ArrayList<>();
        Arrays.sort(nums);
        helper(ans, nums, taken, holder);
        return ans;
    }

    public void helper(List<List<Integer>> ans, int[] nums, boolean taken[], List<Integer> holder) {
        if (holder.size() == nums.length) {
            ans.add(new ArrayList<>(holder));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (taken[i] || (i > 0 && nums[i] == nums[i - 1] && !taken[i - 1])) {
                continue;
            }

            taken[i] = true;
            holder.add(nums[i]);
            helper(ans, nums, taken, holder);
            taken[i] = false;
            holder.remove(holder.size() - 1);

        }
    }
}