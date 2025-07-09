class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < moveFrom.length; i++) {
            if (set.contains(moveFrom[i])) {
                set.remove(moveFrom[i]);
                set.add(moveTo[i]);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int num : set) {
            res.add(num);
        }
        Collections.sort(res);
        return res;
    }
}
