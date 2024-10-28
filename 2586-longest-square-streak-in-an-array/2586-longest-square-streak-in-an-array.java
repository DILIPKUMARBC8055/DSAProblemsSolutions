class Solution {

    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        boolean visited[] = new boolean[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int count = 1;
                int index = i;
                while (index != -1) {
                    index = search(nums, nums[index] * nums[index], index + 1, nums.length - 1);
                    if (index != -1) {
                        visited[index] = true;
                        count++;
                    } else {
                        max = Math.max(max, count);
                        break;
                    }
                }
            }
        }
        return max <= 1 ? -1 : max;
    }

    private int search(int nums[], int target, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return search(nums, target, start, mid - 1);
        } else {
            return search(nums, target, mid + 1, end);
        }
    }
}
