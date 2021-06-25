package algos.tree;

import java.util.ArrayList;
import java.util.List;

import static algos.tree.TreeNode2.n;

public class AllPossibleBinaryTreesWithInorderTraversal {
  public List<TreeNode2> solve(int[] inorder) {
    List<TreeNode2> rst = new ArrayList<>();
    for (int j : inorder) {
      rst = f(rst, j);
    }
    return rst;
  }

  public static void main(String[] args) {
    var s = new AllPossibleBinaryTreesWithInorderTraversal();
    s.solve(new int[]{1, 2, 3})
            .forEach(TreeNode2::print);
  }


  private List<TreeNode2> f(TreeNode2 root, int val) {
    if (root == null) {
      return List.of(n(val));
    }

    var ta = insertAsLeftSubTree((TreeNode2) root.clone(), val);
    var tb = insertAsRightMostLeaf((TreeNode2) root.clone(), val);
    return List.of(ta, tb);
  }

  private List<TreeNode2> f(List<TreeNode2> nodes, int val) {
    if (nodes.isEmpty()) {
      return List.of(n(val));
    }

    var rst = new ArrayList<TreeNode2>();
    for (TreeNode2 node2 : nodes) {
      rst.addAll(f(node2, val));
    }
    return rst;
  }
  private TreeNode2 insertAsRightMostLeaf(TreeNode2 root, int val) {
    assert root != null;
    var p = root;
    while (p.right != null) p = p.right;
    p.right = n(val);
    return root;
  }

  private TreeNode2 insertAsLeftSubTree(TreeNode2 root, int val) {
    return n(val, root, null);
  }
}
