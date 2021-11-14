package algos.tree;

import algos.TreeNode2;

import java.util.LinkedList;
import java.util.Queue;

import static algos.TreeNode2.n;
import static algos.TreeNode2.print;

// deletion in a binary tree
public class BinaryTree02 {
  public static void main(String[] args) {
    var d = n(12, n(4), n(19));
    var tree = n(13,
        d,
        n(10, n(16), n(9)));

    print(tree);
    solve(tree, d);
    print(tree);
  }


  public static void solve(TreeNode2 root, TreeNode2 node) {
    assert root != null;
    assert node != null;
    if (root == node) throw new RuntimeException();

    Queue<TreeNode2> queue = new LinkedList<>();
    queue.offer(root);
    TreeNode2 p = null;
    TreeNode2 n = null;
    while (!queue.isEmpty()) {
      n = queue.poll();

      if (n.left != null) {
        p = n;
        queue.offer(n.left);
      }
      if (n.right != null) {
        p = n;
        queue.offer(n.right);
      }
    }

    TreeNode2 pNode = parent(root, node);
    if (pNode == null) { // just swap with root
      n.left = root.left;
      n.right = root.right;
    } else {
      if (pNode.left == node) pNode.left = n;
      else pNode.right = n;

      if(p.left == n) p.left = null;
      if(p.right == n) p.right = null;

      n.left = node.left;
      n.right = node.right;
    }
  }

  static TreeNode2 parent(TreeNode2 root, TreeNode2 node) {
    if (root == null || node == null || root == node) return null;

    if (root.left == node || root.right == node) return root;
    TreeNode2 p1 = parent(root.left, node);
    if (p1 != null) return p1;
    return parent(root.right, node);
  }
}
