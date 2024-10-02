class Solution {

    public boolean canArrange(int[] arr, int k) {
        if (arr.length % 2 != 0) {
            return false;
        }
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i : arr) {
            int rem = i % k;
            if (rem < 0) {
                rem += k;
            }
            hm.put(rem, hm.getOrDefault(rem, 0) + 1);
        }
        for (int rem : hm.keySet()) {
            if (rem == 0) {
                if (hm.get(rem) % 2 != 0) {
                    return false;
                }
            } else {
                int complement = k - rem;
                if (!hm.containsKey(complement)) return false;
                if (!hm.get(complement).equals(hm.get(rem))) {
                    return false;
                }
            }
        }
        return true;
    }
}
