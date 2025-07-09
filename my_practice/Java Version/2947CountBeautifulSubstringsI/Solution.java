class Solution {
    public int beautifulSubstrings(String s, int k) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int count = 0, count1 = 0;
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    count++;
                } else {
                    count1++;
                }
                if (count == count1 && (count * count1) % k == 0) {
                    res++;
                }
            }
        }
        return res;
    }
}