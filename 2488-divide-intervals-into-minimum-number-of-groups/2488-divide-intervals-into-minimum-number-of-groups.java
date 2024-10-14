class Solution {

    public int minGroups(int[][] intervals) {
        int events[][] = new int[2 * intervals.length][2];
        for (int i = 0; i < intervals.length; i++) {
            events[2 * i][0] = intervals[i][0];
            events[2 * i][1] = 1;
            events[2 * i + 1][0] = intervals[i][1];
            events[2 * i + 1][1] = -1;
        }
        int max = -1;
        Arrays.sort(events, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int answer = 0;
        for (int i = 0; i < events.length; i++) {
            answer += events[i][1];
            if (max < answer) {
                max = answer;
            }
        }
        return max;
    }
}
