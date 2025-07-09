class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> list = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        queue.add(new int[]{0, 0});
        set.add(0 + "*" + 0);
        while (queue.size() > 0) {
            int[] cur = queue.poll();
            int i = cur[0], j = cur[1];
            list.add(nums.get(i).get(j));
            String s1 = (i + 1) + "*" + (j);
            String s2 = (i) + "*" + (j + 1);
            if (i + 1 < nums.size() && j < nums.get(i + 1).size() && !set.contains(s1)) {
                queue.add(new int[]{i + 1, j});
                set.add(s1);
            }
            if (j + 1 < nums.get(i).size() && !set.contains(s2)) {
                queue.add(new int[]{i, j + 1});
                set.add(s2);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
