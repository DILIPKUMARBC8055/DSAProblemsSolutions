class Solution {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String s1[] = sentence1.split(" ");
        String s2[] = sentence2.split(" ");

        int first = 0;
        int second = 0;
        while (first < s1.length && first < s2.length && s1[first].equals(s2[first])) {
            first++;
        }
        while (second < s1.length && second < s2.length && s1[s1.length - 1 - second].equals(s2[s2.length - 1 - second])) {
            second++;
        }
        return first + second >= Math.min(s1.length, s2.length);
    }
}
