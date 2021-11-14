package algos.tree;

import algos.TreeNode2;

import java.util.LinkedList;
import java.util.Queue;

// insertion in a binary tree in level order
public class BinaryTree01 {
  public static void solve(TreeNode2 root, int val) {
    assert root != null;

    Queue<TreeNode2> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode2 n = queue.poll();
      // process node in level order

      if (n.left != null) {
        queue.offer(n.left);
      } else {
        n.left = TreeNode2.n(val);
        return;
      }

      if (n.right != null) {
        queue.offer(n.right);
      } else {
        n.right = TreeNode2.n(val);
        return;
      }
    }
  }
}
