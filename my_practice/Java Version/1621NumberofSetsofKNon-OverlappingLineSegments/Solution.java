import java.math.BigInteger;
class Solution {
    public int numberOfSets(int n, int k) {
        int mod = (int) (Math.pow(10, 9) + 7);
        BigInteger res = BigInteger.valueOf(1);
        for (int i = 1; i < k * 2 + 1; i++) {
            res = res.multiply(BigInteger.valueOf(n + k - i));
            res = res.divide(BigInteger.valueOf(i));
        }
        res = res.mod(BigInteger.valueOf(mod));
        return res.intValue();
    }
}
