class Solution {
    public int findMinDifference(List<String> timePoints) {
        int output = Integer.MAX_VALUE;
        int times[] = new int[timePoints.size()];
        int N = 0;
        for (String str : timePoints) {
            String time[] = str.split(":");
            int min = 0;
            int hours = Integer.parseInt(time[0]);
            min += hours * 60;
            int mins = Integer.parseInt(time[1]);
            min += mins;
            times[N++] = min;
        }
        Arrays.sort(times);
        for (int i = 1; i < times.length; i++) {
            int diff = times[i] - times[i - 1];
            if (diff < output) {
                output = diff;
            }
        }
        int diff = 24 * 60 - times[times.length - 1] + times[0];
        if (diff < output) {
            output = diff;
        }
        return output;

    }
}