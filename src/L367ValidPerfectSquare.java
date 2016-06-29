public class L367ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        long low = 1, high = num >> 1;
        long n = (long) num;
        while (low <= high) {
            long mid = ((high - low) >> 1) + low;
            if (mid * mid == n) {
                return true;
            } else if (mid * mid < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
