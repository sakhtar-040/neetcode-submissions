class Solution {
    public int arrangeCoins(int n) {
        int left = 0, right = n;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long curr = mid * (mid + 1) / 2;

            if (curr == n) {
                return (int) mid;
            } else if (curr < n) {
                left = (int) mid + 1;
            } else {
                right = (int) mid - 1;
            }
        }

        return right;
    }
}