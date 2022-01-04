package algos.misc;

public class Lt124 {
  class Solution {
    public int maxPathSum(TreeNode root) {
      if (root == null) return -1001;
      if (root.left == null && root.right == null) return root.val;

      int m1 = root.val; // include only one root node

      int lm1 = maxPathSum1(root.left);
      int rm1 = maxPathSum1(root.right);
      int m2 = m1 + lm1 + rm1; // include root and left.path and right.path

      int lm = maxPathSum(root.left);
      int rm = maxPathSum(root.right);
      int m3 = Integer.max(lm, rm); // include only left.path or right.path

      int m4 = m1 + Integer.max(lm1, rm1); // include root and left.path or right.path
      return Integer.max(m1, Integer.max(m2, Integer.max(m3, m4)));
    }

    // when include parent's node, at the current node, we can only include one path, left.path or right.path
    int maxPathSum1(TreeNode node) {
      if (node == null) return -1001;
      int m1 = node.val;
      int m2 = node.val + Integer.max(maxPathSum1(node.left), maxPathSum1(node.right));
      return Integer.max(m1, m2);
    }
  }
}
