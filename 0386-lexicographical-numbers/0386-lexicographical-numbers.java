class Solution {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> output = new ArrayList<>();
        for (int i = 1; i < 10 && i<=n; i++) {
            output.add(i);
            helper(i, n, output);
        }
        return output;
    }

    public void helper(int start, int n, List<Integer> output) {
       
        start = start * 10;
        if (start > n) {
            return;
        }
        for (int i = 0; i < 10 && start  <= n; i++) {
            output.add(start);
            helper(start, n, output);
            start++;
        }
       
    }
}
