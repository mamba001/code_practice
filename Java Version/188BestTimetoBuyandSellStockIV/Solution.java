class Solution {
    int[][][] dp;
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        dp = new int[n][k + 1][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k + 1; j++) {
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }

        return solve(0, k, prices, 1);
    }

    private int solve(int i, int k, int[] prices, int canBuy) {
        if (k <= 0 || i >= prices.length) {
            return 0;
        }

        if (dp[i][k][canBuy] != -1) {
            return dp[i][k][canBuy];
        }

        if (canBuy == 1) {
            //can buy or skip
            //if buy
            int buy = -prices[i] + solve(i + 1, k, prices, 0);
            //is skip
            int notBuy = solve(i + 1, k, prices, 1);
            dp[i][k][canBuy] = Math.max(buy, notBuy);
        } else {
            //can sell of skip
            //if sell
            int sell = prices[i] + solve(i + 1, k - 1, prices, 1);
            //if skip
            int notSell = solve(i + 1, k, prices, 0);
            dp[i][k][canBuy] = Math.max(sell, notSell);
        }
        return dp[i][k][canBuy];
    }
}
