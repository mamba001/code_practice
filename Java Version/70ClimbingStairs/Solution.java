class Solution {
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }

        int pre1 = 1;
        int pre2 = 2;
        for (int i = 3; i <= n; i++) {
            int cur = pre1 + pre2;
            pre1 = pre2;
            pre2 = cur;
        }
        return pre2;
    }
}