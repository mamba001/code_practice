class Solution {
    List<String> res = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        dfs(s, words, 0, new ArrayList());
        return res;
    }

    private void dfs(String s, Set<String> words, int index, List<String> list) {
        if (index == s.length()) {
            res.add(String.join(" ", list));
            return;
        }

        for (int next = index + 1; next <= s.length(); next++) {
            String word = s.substring(index, next);
            if (words.contains(word)) {
                list.add(word);
                dfs(s, words, next, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
