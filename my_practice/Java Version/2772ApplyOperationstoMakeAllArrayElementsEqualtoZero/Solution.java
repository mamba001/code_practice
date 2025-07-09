class Solution {
    public boolean checkArray(int[] nums, int k) {
        int n = nums.length;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if (cur > nums[i]) {
                return false;
            }

            nums[i] -= cur;
            cur += nums[i];
            if (i >= k - 1) {
                cur -= nums[i - k + 1];
            }
        }
        return cur == 0;
    }
}
