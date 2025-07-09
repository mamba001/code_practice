class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        int dominant = nums.get(0);
        int count = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > count) {
                count = map.get(num);
                dominant = num;
            }
        }

        int freq1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) == dominant) {
                freq1++;
                int freq2 = count - freq1;
                if (freq1 * 2 > i + 1 && freq2 * 2 > n - i - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}