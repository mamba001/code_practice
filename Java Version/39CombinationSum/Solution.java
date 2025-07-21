class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, 0, 0, target, new ArrayList(), res);
        return res;
    }

    private void dfs(int[] nums, int level, int sum, int target, List<Integer> list, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList(list));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = level; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i, sum + nums[i], target, list, res);
            list.remove(list.size() - 1);
        }
    }
}