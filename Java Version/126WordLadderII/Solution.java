class Solution {
    Map<String, Integer> map;
    List<List<String>> res;
    String b;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return new ArrayList();
        }
        map = new HashMap();
        map.put(beginWord, 1);
        b = beginWord;
        set.remove(b);
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int steps = map.get(word);
            if (word.equals(endWord)) {
                break;
            }

            for (String next : generate(word)) {
                if (set.contains(next)) {
                    queue.add(next);
                    set.remove(next);
                    map.put(next, steps + 1);
                }
            }
        }
        res = new ArrayList();

        if (map.get(endWord) != null) {
            List<String> list = new ArrayList<>();
            list.add(endWord);
            dfs(endWord, list);
        }
        return res;
    }

    private void dfs(String word, List<String> list) {
        if (word.equals(b)) {
            List<String> path = new ArrayList<>(list);
            Collections.reverse(path);
            res.add(path);
            return;
        }

        for (String next : generate(word)) {
            if (map.get(next) != null && map.get(next) == map.get(word) - 1) {
                list.add(next);
                dfs(next, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private List<String> generate(String word) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            StringBuilder sb = new StringBuilder(word);
            for (int j = 0; j < 26; j++) {
                sb.setCharAt(i, (char) ('a' + j));
                String str = sb.toString();
                if (!str.equals(word)) {
                    res.add(str);
                }
            }
        }
        return res;
    }
}
