package algos.tree;

import algos.TreeNode2;

import static algos.TreeNode2.n;

/**
 * @see "https://www.geeksforgeeks.org/density-of-binary-tree-in-one-traversal/"
 */
public class BinaryTree05 {
  public static void main(String[] args) {
    var t = n(10, n(20, n(30), null), null);
    float d = density(t);
    System.out.println(d);
  }

  public static float density(TreeNode2 root) {
    int[] size = new int[]{0};
    int height = helper(root, size);
    return (float) size[0] / (float) height;
  }

  private static int helper(TreeNode2 root, int[] size) {
    if (root == null) return 0;
    size[0]++;
    if (root.left == null && root.right == null) return 1;

    int lh = helper(root.left, size);
    int rh = helper(root.right, size);
    return 1 + Math.max(lh, rh);
  }

}
