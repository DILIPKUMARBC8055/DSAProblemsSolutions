class Solution {

    public int minChanges(String s) {
        if (s.length() == 0) return 0;
        ArrayList<Integer> arr = new ArrayList<>();
        int count = 0;
        int start = 0;
        int i = 1;
        int n = s.length();
        while (i < n) {
            while (i < n && s.charAt(i) == s.charAt(i - 1)) i++;
            if ((i - start) % 2 == 1) arr.add(count);
            count++;
            start = i;
            i++;
        }
        if ((i - start) % 2 == 1) arr.add(count);
        int ans = 0;
        for (int m = 1; m < arr.size(); m += 2) {
            ans += arr.get(m) - arr.get(m - 1);
        }
        return ans;
    }
}
