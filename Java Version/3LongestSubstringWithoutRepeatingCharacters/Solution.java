class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int left = 0;
        int res = 1;
        set.add(s.charAt(0));
        for (int right = 1; right < s.length(); right++) {
            char c = s.charAt(right);
            while (set.contains(c)) {
                set.remove(s.charAt(left++));
            }
            set.add(c);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}