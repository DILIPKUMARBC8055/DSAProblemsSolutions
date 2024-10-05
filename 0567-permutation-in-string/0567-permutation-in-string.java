class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int freq[] = new int[26];
        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }
        int holder[] = reset(freq);
        int count = 0;
        boolean foundFirstLetter = false;
        for (int i = 0; i < s2.length(); i++) {
            //System.out.println("This is at the begin"+i);
            if (holder[s2.charAt(i) - 'a'] > 0) {
                foundFirstLetter = true;
                holder[s2.charAt(i) - 'a']--;
                count++;
            } else if (foundFirstLetter && holder[s2.charAt(i) - 'a'] <= 0) {
                holder = reset(freq);
                foundFirstLetter = false;
                i=i-count;
                //System.out.println("This is inside reset"+i);
                count = 0;
            }
            if (count == s1.length()) return true;
        }
        return count == s1.length();
    }

    public int[] reset(int freq[]) {
        int resetArray[] = new int[freq.length];
        for (int i = 0; i < freq.length; i++) {
            resetArray[i] = freq[i];
        }
        return resetArray;
    }
}
