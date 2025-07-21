class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();
        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2]}); // 起点，高度为负值
            events.add(new int[]{b[1], b[2]});  // 终点，高度为正值
        }

        // 按照 x 排序，若 x 相同，起点在前，终点在后（高度负值优先）
        events.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        heap.add(0); // 初始地面高度
        int prev = 0;

        for (int[] e : events) {
            int x = e[0], h = e[1];
            if (h < 0) {
                heap.add(-h); // 进入建筑
            } else {
                heap.remove(h); // 离开建筑
            }

            int curr = heap.peek();
            if (curr != prev) {
                res.add(List.of(x, curr));
                prev = curr;
            }
        }

        return res;
    }
}