class Solution {

    public int[] smallestRange(List<List<Integer>> nums) {
        int maxElement = Integer.MIN_VALUE;
        int range = Integer.MAX_VALUE;
        int[] output = new int[] { 0, Integer.MAX_VALUE };
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int i = 0;
        for (List<Integer> l : nums) {
            int firstElement = l.get(0);
            if (firstElement > maxElement) {
                maxElement = firstElement;
            }
            minHeap.add(new int[] { firstElement, i, 0 });
            i++;
        }
        while (!minHeap.isEmpty()) {
            int top[] = minHeap.poll();
            int newRange = maxElement - top[0];
            if (range > newRange) {
                range = newRange;
                output[0] = top[0];
                output[1] = maxElement;
            }
            int col = top[2];
            if (nums.get(top[1]).size() <= col + 1) {
                return output;
            } else {
                int newElement = nums.get(top[1]).get(col + 1);
                minHeap.add(new int[]{newElement, top[1], col + 1});
                if (newElement > maxElement) {
                    maxElement = newElement;
                }
            }
        }
        return output;
    }
}
