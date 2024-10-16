class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>((x,y)->y[0]-x[0]);
        
        if(a!=0)
        {
            maxHeap.add(new int[]{a,1});
        }
        if(b!=0)
        {
            maxHeap.add(new int[]{b,2});
        }
        if(c!=0)
        {
             maxHeap.add(new int[]{c,3});
        }
        int strickA=0;
        int strickB=0;
        int strickC=0;
        StringBuilder result=new StringBuilder();
        while(!maxHeap.isEmpty())
        {
            int[] top = maxHeap.poll();
            int count = top[0];
            char ch = (char) ('a' + top[1] - 1); // Map 1 -> 'a', 2 -> 'b', 3 -> 'c'

            // Handle case where we already have two consecutive of the current char
            if ((ch == 'a' && strickA == 2) || 
                (ch == 'b' && strickB == 2) || 
                (ch == 'c' && strickC == 2)) {
                
                if (maxHeap.isEmpty()) break; // No other characters to pick

                // Get the second most frequent character
                int[] next = maxHeap.poll();
                char nextCh = (char) ('a' + next[1] - 1);
                result.append(nextCh);
                
                if (nextCh == 'a') {
                    strickA++;
                    strickB = strickC = 0;
                } else if (nextCh == 'b') {
                    strickB++;
                    strickA = strickC = 0;
                } else {
                    strickC++;
                    strickA = strickB = 0;
                }

                if (--next[0] > 0) {
                    maxHeap.add(next); // Reinsert if there are still counts left
                }

                // Put the previous top element back in the heap
                maxHeap.add(top);
            } else {
                // Append the most frequent character
                result.append(ch);

                if (ch == 'a') {
                    strickA++;
                    strickB = strickC = 0;
                } else if (ch == 'b') {
                    strickB++;
                    strickA = strickC = 0;
                } else {
                    strickC++;
                    strickA = strickB = 0;
                }

                // Reinsert the character with one less count if count > 1
                if (--top[0] > 0) {
                    maxHeap.add(top);
                }
            }
            
        }
        return result.toString();
    }
    
}