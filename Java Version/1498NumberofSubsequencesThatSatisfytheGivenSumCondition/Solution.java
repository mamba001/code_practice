class Solution {
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        long res = 0l;
        int mod = (int) (Math.pow(10, 9) + 7);
        int[] pows = new int[n];
        pows[0] = 1;
        for (int i = 1 ; i < n ; ++i) {
            pows[i] = pows[i - 1] * 2 % mod;
        }

        int left = 0, right = n - 1;
        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                res = (res + pows[right - left]) % mod;
                left++;
            }
        }
        return (int) res;
    }
}