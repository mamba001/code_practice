class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int line = 0, row = 1;
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            if (line + widths[index] <= 100) {
                line += widths[index];
            } else {
                line = widths[index];
                row++;
            }
        }
        return new int[]{row, line};
    }
}