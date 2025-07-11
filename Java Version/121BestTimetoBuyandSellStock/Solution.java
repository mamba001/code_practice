class Solution {
    public int maxProfit(int[] prices) {
        int minBuy = prices[0];
        int n = prices.length;
        int res = 0;
        for (int i = 1; i < n; i++) {
            minBuy = Math.min(minBuy, prices[i]);
            res = Math.max(res, prices[i] - minBuy);
        }
        return res;
    }
}
