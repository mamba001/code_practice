class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        int[] suffix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = Math.max(prefix[i], nums[i]);
            suffix[n - i - 1] = Math.max(suffix[n - i], nums[n - i - 1]);
        }

        long res = 0l;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (prefix[i] - nums[i]) * (long) suffix[i + 1]);
        }
        return res;
    }
}
