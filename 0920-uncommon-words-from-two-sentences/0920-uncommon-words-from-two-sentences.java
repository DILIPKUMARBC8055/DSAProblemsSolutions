class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String wordInS1[] = s1.split(" ");
        String wordInS2[] = s2.split(" ");
        HashMap<String, Integer> hm = new HashMap<>();
        ArrayList<String> output = new ArrayList<>();
        for (String str : wordInS1) {
            hm.put(str, hm.getOrDefault(str,0)+1);
        }
        for (String str : wordInS2) {
           hm.put(str, hm.getOrDefault(str,0)+1);
        }
        for(String str:hm.keySet())
        {
            if(hm.get(str)==1)
            {
                output.add(str);
            }
        }
        return output.toArray(new String[0]);
    }
}