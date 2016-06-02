import java.util.LinkedList;

public class L297SerializeAndDeserializeBinaryTree {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuffer sb = new StringBuffer();
            preorder(root, sb);
            return sb.substring(0, sb.length() - 1);
        }

        private void preorder(TreeNode node, StringBuffer sb) {
            if (node == null) {
                sb.append("# ");
            } else {
                sb.append(node.val + " ");
                preorder(node.left, sb);
                preorder(node.right, sb);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] vals = data.split(" ");
            TreeNode root = vals[0].equals("#") ? null : new TreeNode(Integer.valueOf(vals[0]));
            LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
            stack.push(root);
            boolean left = true;
            for (int i = 1; i < vals.length; ++i) {
                TreeNode cur = vals[i].equals("#") ? null : new TreeNode(Integer.valueOf(vals[i]));
                if (left) {
                    stack.peek().left = cur;
                    if (cur == null)
                        left = false;
                } else {
                    stack.pop().right = cur;
                    if (cur != null)
                        left = true;
                }
                if (cur != null)
                    stack.push(cur);
            }
            return root;
        }

        public String serialize1(TreeNode root) {
            StringBuffer sb = new StringBuffer();
            LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; ++i) {
                    TreeNode cur = queue.poll();
                    if (cur != null) {
                        sb.append(cur.val + " ");
                        queue.offer(cur.left);
                        queue.offer(cur.right);
                    } else {
                        sb.append("# ");
                    }
                }
            }
            return sb.substring(0, sb.length() - 1);
        }

        public TreeNode deserialize1(String data) {
            String[] vals = data.split(" ");
            TreeNode root = vals[0].equals("#") ? null : new TreeNode(Integer.valueOf(vals[0]));
            LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            for (int i = 1; i < vals.length; i = i + 2) {
                TreeNode cur = queue.poll();
                TreeNode left = vals[i].equals("#") ? null : new TreeNode(Integer.valueOf(vals[i]));
                TreeNode right = vals[i + 1].equals("#") ? null : new TreeNode(Integer.valueOf(vals[i + 1]));
                cur.left = left;
                cur.right = right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            return root;
        }
    }
}
