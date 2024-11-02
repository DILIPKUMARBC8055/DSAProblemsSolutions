class Solution {
    public boolean isCircularSentence(String sentence) {
       if(sentence.charAt(0)!=sentence.charAt(sentence.length()-1)) return false;
       
        String[] str=sentence.split(" ");
        char last=str[0].charAt(str[0].length()-1);
        char first='q';
        for(int i=1;i<str.length;i++)
        {
            first=str[i].charAt(0);
            if(first!=last)
            {
                return false;
            }
            last=str[i].charAt(str[i].length()-1);

        }
        return true;
    }
}