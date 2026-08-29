class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;
        long lo = 1, hi = x, ans = 0;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (mid * mid <= x) {
                ans = mid;        // candidate, try bigger
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return (int) ans;
    }
}