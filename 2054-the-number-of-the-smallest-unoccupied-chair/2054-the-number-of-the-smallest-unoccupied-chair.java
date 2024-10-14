class Solution {

    public int smallestChair(int[][] times, int targetFriend) {
        int[][] events = new int[times.length * 2][3];
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        PriorityQueue<int[]> occupiedChairs = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < times.length; i++) {
            availableChairs.add(i);
            events[2 * i][0] = times[i][0];
            events[2 * i][1] = i;
            events[2 * i][2] =  times[i][1];
            events[2 * i + 1][0] = times[i][1];
            events[2 * i + 1][1] = -1;
        }
        Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : Integer.compare(a[0], b[0]));
        for (int i = 0; i < events.length; i++) {
            if (events[i][1] == -1) {
                while (!occupiedChairs.isEmpty() && occupiedChairs.peek()[0] <= events[i][0]) {
                    availableChairs.add(occupiedChairs.poll()[1]);
                }
            } else {
                if (events[i][1] == targetFriend) {
                    if(!availableChairs.isEmpty())
                   return  availableChairs.poll();
                }
                int charNumber=-1;
                if(!availableChairs.isEmpty())
                charNumber=availableChairs.poll();
                occupiedChairs.add(new int[]{events[i][2],charNumber});
            }
        }
        return -1;
    }
}
