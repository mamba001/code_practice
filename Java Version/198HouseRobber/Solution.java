class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i] = nums[i];
                continue;
            }
            if (i == 1) {
                dp[i] = Math.max(nums[0], nums[1]);
                continue;
            }
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }
}    
}
