class Solution {

    public double[] medianSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(nums[i]);
        }
        Collections.sort(list);
        double[] output = new double[nums.length - k + 1];
        int index = 0;
        output[index++] = findMedian(list, k);
        for (int i = k; i < nums.length; i++) {
            deleteTheNumber(list, nums[i - k]);
            addTheNumber(list, nums[i]);
            output[index++] = findMedian(list, k);
        }
        return output;
    }

    public double findMedian(ArrayList<Integer> list, int k) {
        if (k % 2 == 1) {
            return (double) list.get(k / 2);
        } else {
            double a = list.get(k / 2 - 1);
            double b = list.get(k / 2);
            return (a + b) / 2;
        }
    }

    public void addTheNumber(ArrayList<Integer> list, int target) {
        int index = binarySearch(list, target, 0, list.size() - 1);

        list.add(index, target);
    }

    public void deleteTheNumber(ArrayList<Integer> list, int target) {
        int index = binarySearch(list, target, 0, list.size() - 1);
        list.remove(index);
    }

    public int binarySearch(ArrayList<Integer> list, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) == target) {
                return mid; 
            } else if (list.get(mid) > target) {
                end = mid - 1; 
            } else {
                start = mid + 1;
            }
        }
        return start; // Return the insertion point if the target is not found
    }
}
