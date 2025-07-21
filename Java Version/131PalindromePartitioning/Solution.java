class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> solution = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return solution;
        }
        dfs(s.toCharArray(), 0, new ArrayList(), solution);
        return solution;
    }

    private void dfs(char[] c, int index, List<String> sol, List<List<String>> solution) {
        if (index == c.length) {
            solution.add(new ArrayList(sol));
            return;
        }

        for (int i = index; i < c.length; i++) {
            String newString = new String(c, index, i + 1 - index);
            if (isPalindromic(newString)) {
                sol.add(newString);
                dfs(c, i + 1, sol, solution);
                sol.remove(sol.size() - 1);
            }
        }
    }

    private boolean isPalindromic(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
