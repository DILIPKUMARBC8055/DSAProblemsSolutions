class Solution {

    public boolean checkInclusion(String s1, String s2) {
        // if (s1.length() > s2.length()) return false;
        // int freq[] = new int[26];
        // for (char c : s1.toCharArray()) {
        //     freq[c - 'a']++;
        // }
        // int holder[] = reset(freq);
        // int count = 0;
        // boolean foundFirstLetter = false;
        // for (int i = 0; i < s2.length(); i++) {
        //     //System.out.println("This is at the begin"+i);
        //     if (holder[s2.charAt(i) - 'a'] > 0) {
        //         foundFirstLetter = true;
        //         holder[s2.charAt(i) - 'a']--;
        //         count++;
        //     } else if (foundFirstLetter && holder[s2.charAt(i) - 'a'] <= 0) {
        //         holder = reset(freq);
        //         foundFirstLetter = false;
        //         i=i-count;
        //         //System.out.println("This is inside reset"+i);
        //         count = 0;
        //     }
        //     if (count == s1.length()) return true;
        // }
        // return count == s1.length();
        if (s1.length() > s2.length()) return false;
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            if (Arrays.equals(freq1, freq2)) return true;
            freq2[s2.charAt(i - s1.length())-'a']--;
            freq2[s2.charAt(i) - 'a']++;
        }
        return Arrays.equals(freq1, freq2);
    }

    // public int[] reset(int freq[]) {
    //     int resetArray[] = new int[freq.length];
    //     for (int i = 0; i < freq.length; i++) {
    //         resetArray[i] = freq[i];
    //     }
    //     return resetArray;
    // }
}
