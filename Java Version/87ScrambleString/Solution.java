class Solution {
    Map<String, Boolean> map = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if (s2.length() != n) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        if (n == 1) {
            return false;
        }

        String key = s1 + " " + s2;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        for (int i = 1; i < n; i++) {
            boolean woSwap = (isScramble(s1.substring(i, n), s2.substring(i, n)) && 
                              isScramble(s1.substring(0, i), s2.substring(0, i)));
            
            if (woSwap) {
                map.put(key, true);
                return true;
            }

            boolean wSwap = (isScramble(s1.substring(0, i), s2.substring(n - i, n)) && 
                              isScramble(s1.substring(i, n), s2.substring(0, n - i)));
            
            if (wSwap) {
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }
}
