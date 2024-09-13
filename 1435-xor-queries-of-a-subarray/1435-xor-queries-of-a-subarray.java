class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int output[] = new int[queries.length];
        int temp[] = new int[arr.length];
        temp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            temp[i] =  arr[i] ^ temp[i - 1];

        }
        int k = 0;
        for (int q[] : queries) {
            if(q[0]==0)
            {
                output[k++]=temp[q[1]];
            }else 
            output[k++] = temp[q[0] -1] ^ temp[q[1]];
        }
        return output;
    }
}