class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int mod = (int) (1e9 + 7);
        List<Integer> pows = new ArrayList<>();
        for (int i = 0; n > 0; i++) {
            if ((n & 1) == 1) {
                pows.add(1 << i);
            }
            n >>= 1;
        }

        int[] res = new int[queries.length];

        for (int k = 0; k < queries.length; k++) {
            int left = queries[k][0];
            int right = queries[k][1];

            long product = 1l;
            for (int i = left; i <= right; i++) {
                product = (product * pows.get(i)) % mod;
            }
            res[k] = (int) product;
        }
        return res;
    }
}