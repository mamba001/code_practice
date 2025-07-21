class Solution {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }

        int total = 0;
        while (num > 0) {
            int last = num % 10;
            total += last;
            num /= 10;
        }
        return addDigits(total);
    }
}
