class Solution {

    public boolean canArrange(int[] arr, int k) {
        if (arr.length % 2 != 0) {
            return false;
        }
        int hm[] = new int[k];

        for (int i : arr) {
            int rem = i % k;
            if (rem < 0) {
                rem += k;
            }
            hm[rem]++;
        }
        if (hm[0] % 2 != 0) return false;
        for (int i = 1; i <= k / 2; i++) {
            if (hm[i] != hm[k - i]) {
                return false;
            }
        }
        return true;
    }
}
