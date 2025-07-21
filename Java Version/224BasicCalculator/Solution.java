class Solution {
    public int calculate(String s) {
        int n = s.length();
        long sign = 1;
        long ans = 0;
        long curNo = 0;
        Stack<Long> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) {
                curNo = s.charAt(i) - '0';
                while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
                    curNo = curNo * 10 + s.charAt(i + 1) - '0';
                    i++;
                }

                curNo = curNo * sign;
                ans += curNo;
                curNo = 0;
                sign = 1;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(ans);
                stack.push(sign);
                ans = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                long preSign = stack.pop();
                ans = preSign * ans;
                long prevAns = stack.pop();
                ans += prevAns;
            }
        }
        return (int) ans;
    }
}