class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        return dfs(s, 0, words, new Boolean[s.length()]);
    }

    private boolean dfs(String s, int start, Set<String> words, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }

        if (memo[start] != null) {
            return memo[start];
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String word = s.substring(start, i);
            if (words.contains(word) && dfs(s, i, words, memo)) {
                memo[start] = true;
                return true;
            }
        }
        memo[start] = false;
        return false;
    }
}