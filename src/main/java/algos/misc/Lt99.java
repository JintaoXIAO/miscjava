package algos.misc;


public class Lt99 {
  class Solution {
    TreeNode t1, t2, p;
    public void recoverTree(TreeNode root) {
      inorder(root);
      swapValue(t1, t2);
    }

    private void swapValue(TreeNode t1, TreeNode t2) {
      if (t1 == null || t2 == null) return;
      int tmp = t1.val;
      t1.val = t2.val;
      t2.val = tmp;
    }

    void inorder(TreeNode node) {
      if (node == null) return;
      inorder(node.left);

      if (p != null && p.val > node.val) {
        if (t1 == null) t1 = p;
        t2 = node;
      }

      p = node;
      inorder(node.right);
    }
  }
}
