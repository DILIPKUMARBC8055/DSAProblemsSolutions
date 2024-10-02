class Solution {

    public int[] arrayRankTransform(int[] arr) {
        int result[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        Arrays.sort(arr);
        HashMap<Integer, Integer> hm = new HashMap<>();
        int rank = 1;
        for (int i : arr) {
            if (!hm.containsKey(i)) {
                hm.put(i, rank);
                rank++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            result[i] = hm.get(result[i]);
        }
        return result;
    }
}
