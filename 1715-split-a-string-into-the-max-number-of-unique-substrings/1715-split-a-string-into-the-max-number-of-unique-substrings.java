class Solution {

    public int maxUniqueSplit(String s) {
        // HashSet<String> set = new HashSet<>();
        // boolean exist = false;
        // String str = new String();
        // for (char c : s.toCharArray()) {
        //     if (exist) {
        //         str += c;
        //     } else {
        //         str = c + "";
        //     }
        //     if (set.contains(str)) {
        //         exist = true;
        //     } else {
        //         set.add(str);
        //         exist = false;
        //     }
        // }
        // return set.size();
        return getMax(s, new HashSet<>(), 0);
    }

    private int getMax(String s, HashSet<String> set, int start) {
        if (start == s.length()) return 0;
        int max = 0;
        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if (!set.contains(str)) {
                set.add(str);
                max = Math.max(max, 1 + getMax(s, set, i));
                set.remove(str);
            }
        }
        return max;
    }
}
