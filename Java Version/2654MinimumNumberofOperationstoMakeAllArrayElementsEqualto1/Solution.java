class Solution {
    public int minOperations(int[] nums) {
        int countOne = 0;
        for (int num : nums) {
            if (num == 1) {
                countOne++;
            }
        }

        if (countOne > 0) {
            return nums.length - countOne;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int common = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                common = gcd(common, nums[j]);
                if (common == 1) {
                    res = Math.min(res, j - i + nums.length - 1);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int gcd(int x, int y) {
        if (x == 0) {
            return y;
        }
        return gcd(y % x, x);
    }
}
