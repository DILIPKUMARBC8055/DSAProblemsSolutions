class Solution {

    public String makeFancyString(String s) {
        // char second = 'A';
        // Stack<Character> stack = new Stack<>();
        // for (char c : s.toCharArray()) {
        //     if (stack.isEmpty()) {
        //         stack.push(c);
        //     } else if (stack.size() == 1) {
        //         second = stack.peek();
        //         stack.push(c);
        //     } else {
        //         if (!(second == stack.peek() && stack.peek() == c)) {
        //             second = stack.peek();
        //             stack.push(c);
        //         }
        //     }
        // }
        // StringBuilder str = new StringBuilder();
        // while (!stack.isEmpty()) {
        //     str.append(stack.pop() + "");
        // }
        // return str.reverse().toString();
        int sameCount=0;
        StringBuilder sb=new StringBuilder();
        char last=s.charAt(0);
       
        for(char now: s.toCharArray())
        {
            if(now==last) sameCount++;
            else sameCount=1;
            if(sameCount<3) sb.append(now);
            last=now;
        }
        return sb.toString();
    }
}
