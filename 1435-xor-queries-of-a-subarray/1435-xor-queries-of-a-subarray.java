class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int output[] = new int[queries.length];
        int k = 0;
        for (int q[] : queries) {
            int num = 0;
            for (int i = q[0]; i <= q[1]; i++) {
                num ^= arr[i];
            }
            output[k++] = num;
        }
        return output;
    }
}