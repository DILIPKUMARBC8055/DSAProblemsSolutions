class Solution {

    public int maximumSwap(int num) {
        ArrayList<Integer> digits = new ArrayList<>();
        while (num != 0) {
            digits.add(num % 10);
            num /= 10;
        }
        int maxArr[]=new int[digits.size()];
        
        int maxIndex=0;
        for(int i=0;i<digits.size();i++)
        {
            if(digits.get(i)>digits.get(maxIndex))
            {
               maxIndex=i;
            }
            maxArr[i]=maxIndex;
        }
        for(int i=digits.size()-1;i>=0;i--)
        {
            if(digits.get(i)!=digits.get(maxArr[i]))
            {
                int temp=digits.get(i);
                digits.set(i,digits.get(maxArr[i]));
                digits.set(maxArr[i],temp);
                break;
            }
        }
        int newNumber=0;
        for(int i=digits.size()-1;i>=0;i--)
        {
           newNumber=newNumber*10+digits.get(i);

        }
        return newNumber;
        
    }
}
