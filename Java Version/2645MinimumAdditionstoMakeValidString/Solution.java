class Solution {
    public int addMinimum(String word) {
        int index = 0;
        int res = 0;
        String abc = "abc";
        for (char c : word.toCharArray()) {
            while (c != abc.charAt(index % 3)) {
                res++;
                index++;
            }
            index++;
        }
        while (abc.charAt(index % 3) != 'a') {
            index++;
            res++;
        }
        return res;
    }
}
