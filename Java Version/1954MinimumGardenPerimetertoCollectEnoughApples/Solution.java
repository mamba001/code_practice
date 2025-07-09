class Solution {
    public long minimumPerimeter(long neededApples) {
        long l = 1l;
        while (2 * l * (l + 1) * (l * 2 + 1) < neededApples) {
            l++;
        }
        return l * 8;
    }
}
