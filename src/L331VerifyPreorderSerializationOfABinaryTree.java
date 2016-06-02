public class L331VerifyPreorderSerializationOfABinaryTree {
    public class Solution {
        public boolean isValidSerialization(String preorder) {
            String[] input = preorder.split(",");
            int degree = -1;
            for (String str : input) {
                degree++;
                if (degree > 0) {
                    return false;
                }
                if (!str.equals("#")) {
                    degree -= 2;
                }
            }
            return degree == 0;
        }
    }
}
