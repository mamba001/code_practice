class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    return step;
                }

                for (String next : generate(cur)) {
                    if (set.contains(next) && !visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
            step++;
        }
        return 0;
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