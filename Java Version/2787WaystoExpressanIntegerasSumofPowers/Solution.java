class Solution {
    public int numberOfWays(int n, int x) {
        int[] dp = new int[n + 1];
        int v;
        dp[0] = 1;
        int mod = (int) (Math.pow(10, 9) + 7);
        for (int a = 1; (v = (int) Math.pow(a, x)) <= n; a++) {
            for (int i = n; i >= v; i--) {
                dp[i] = (dp[i] + dp[i - v]) % mod;
            }
        }
        return dp[n];
    }
}
