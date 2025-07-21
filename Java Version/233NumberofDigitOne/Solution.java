class Solution {
    public int countDigitOne(int n) {
        int res = 0;
        int q = n;
        int last = 0;
        int x = 1;
        while (q > 0) {
            last = q % 10;
            q /= 10;
            res += q * x;
            if (last == 1) {
                res += n % x + 1; 
            }
            if (last > 1) {
                res += x;
            }
            x *= 10;
        }
        return res;
    }
}
