class Solution {

    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i : nums) {
            maxHeap.add(i);
        }
        long answer = 0;
        while (k > 0) {
            answer += maxHeap.peek();

            int newElement = (int) Math.ceil((double) maxHeap.poll() / 3);

            maxHeap.add(newElement);
            k--;
        }
        return answer;
    }
}
