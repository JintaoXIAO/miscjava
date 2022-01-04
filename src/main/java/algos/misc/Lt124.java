package algos.misc;

public class Lt124 {
  class Solution {
    public int maxPathSum(TreeNode root) {
      if (root == null) return -1001;
      if (root.left == null && root.right == null) return root.val;

      int m1 = root.val;

      int lm1 = maxPathSum1(root.left);
      int rm1 = maxPathSum1(root.right);
      int m2 = m1 + lm1 + rm1;

      int lm = maxPathSum(root.left);
      int rm = maxPathSum(root.right);
      int m3 = Integer.max(lm, rm);

      int m4 = m1 + Integer.max(lm1, rm1);
      return Integer.max(m1, Integer.max(m2, Integer.max(m3, m4)));
    }

    int maxPathSum1(TreeNode node) {
      if (node == null) return -1001;
      int m1 = node.val;
      int m2 = node.val + Integer.max(maxPathSum1(node.left), maxPathSum1(node.right));
      return Integer.max(m1, m2);
    }
  }
}
