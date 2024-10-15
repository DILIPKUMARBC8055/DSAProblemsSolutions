class Solution {

    public long minimumSteps(String s) {
        int start = 0;
        long answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                answer += (i - start);
                start++;
            }
        }
        return answer;
    }
}
