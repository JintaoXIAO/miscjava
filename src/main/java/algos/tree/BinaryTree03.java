package algos.tree;

import algos.TreeNode2;

import static algos.TreeNode2.n;
import static algos.TreeNode2.print;

/**
 * @see "https://www.geeksforgeeks.org/modify-binary-tree-get-preorder-traversal-using-right-pointers/"
 */
public class BinaryTree03 {

  public static void main(String[] args) {
    TreeNode2 root =
        n(10,
            n(8, n(3), n(5)),
            n(2));
    solve(root);
    print(root);
  }

  public static void solve(TreeNode2 root) {
    preOrderProcess(root);
  }

  private static TreeNode2 preOrderProcess(TreeNode2 root) {
    if (root == null) return null;

    if (root.left == null && root.right == null) return root;
    if (root.left == null) return preOrderProcess(root.right);
    if (root.right == null) {
      root.right = root.left;
      root.left = null;
      preOrderProcess(root.right);
    }

    TreeNode2 lt = preOrderProcess(root.left);
    lt.right = root.right;
    TreeNode2 rt = preOrderProcess(root.right);
    root.right = root.left;
    root.left = null;

    return rt;
  }
}
