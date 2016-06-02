public class L343IntegerBreak {
    public class Solution {
        public int integerBreak(int n) {
            int three_num = n / 3;
            int left = n % 3;
            switch (left) {
                case 1:
                    return (int) Math.pow(3, three_num - 1) * 2 * 2;
                case 2:
                    return n == 2 ? 1 : (int) Math.pow(3, three_num) * 2;
                default:
                    return n == 3 ? 2 : (int) Math.pow(3, three_num);
            }
        }
    }
}
