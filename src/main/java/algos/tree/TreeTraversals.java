package algos.tree;


import algos.TreeNode2;

import java.util.*;

import static algos.TreeNode2.n;
import static algos.TreeNode2.print;

public class TreeTraversals {
  public static void main(String[] args) {

  }

  static class NumberOfBinaryTreesForGivenPreorderSequenceLength implements Runnable {

    public void run() {
      int a = solve(8);
      System.out.println(a);
    }

    int solve(int n) {
      int[] dp = new int[n + 1];
      dp[0] = 1;
      dp[1] = 1;
      dp[2] = 2;
      dp[3] = 5;

      // for accelerating
      for (int i = 0; i < n; i++) {
        solve(i, dp);
      }
      return solve(n, dp);
    }

    int solve(int n, int[] dp) {
      if (dp[n] > 0) return dp[n];

      int result = 0;
      for (int i = 0; i < n; i++) {
        result += solve(i, dp) * solve(n - 1 - i, dp);
      }
      dp[n] = result;
      return dp[n];
    }
  }

  static class PrintPostOrderTraversalFromGivenInorderAndPreorderTraversals implements Runnable {
    public void solve(int[] inorder, int[] preorder) {
      h(inorder, 0, inorder.length - 1, preorder, 0);
    }

    /*
    inorder: [4,2,5,1,3,6]
    preorder: [1,2,4,5,3,6]
    postorder: [4,5,2,6,3,1]
     */
    private void h(int[] inorder, int s, int e, int[] preorder, int idx) {
      if (s == e) {
        System.out.println(inorder[s]);
        return;
      }
      if (s > e || idx >= preorder.length) {
        return;
      }

      int j = s;
      while (j < inorder.length && inorder[j] != preorder[idx]) {
        j++;
      }
      if (j < inorder.length) {
        h(inorder, s, j - 1, preorder, idx + 1);
        h(inorder, j + 1, e, preorder, j + 1);
        h(inorder, j, j, preorder, idx);
      }
    }

    @Override
    public void run() {
      var p = new PrintPostOrderTraversalFromGivenInorderAndPreorderTraversals();
      var inorder = new int[]{4, 2, 5, 1, 3, 6};
      var preorder = new int[]{1, 2, 4, 5, 3, 6};
      p.solve(inorder, preorder);
    }
  }

  static class PostorderOfBSTFromPreorderTraversal implements Runnable {
    /*
  input: [40,30,35,80,100]
  output: [35,30,100,80,40]
   */
    public void solve(int[] preorder) {
      h(preorder, 0, preorder.length - 1);
    }

    private void h(int[] preorder, int s, int e) {
      if (s > e) return;
      var i = s + 1;
      while (i <= e && preorder[i] < preorder[s]) i++;
      h(preorder, s + 1, i - 1);
      h(preorder, i, e);
      System.out.println(preorder[s]);
    }

    @Override
    public void run() {
      var arr = new int[]{40, 30, 35, 80, 100};
      var p = new PostorderOfBSTFromPreorderTraversal();
      p.solve(arr);

    }
  }

  static class BoundaryTraversalOfBinaryTree implements Runnable {
    public static void boundaryTraversal(TreeNode2 root) {
      if (root == null) return;

      Queue<TreeNode2> queue = new LinkedList<>();
      queue.offer(root);
      Stack<TreeNode2> stack = new Stack<>();
      while (!queue.isEmpty()) {
        List<TreeNode2> nodes = new LinkedList<>();
        TreeNode2 last = null;
        while (!queue.isEmpty()) {
          last = queue.poll();
          nodes.add(last);
        }
        stack.push(last);
        TreeNode2 head = nodes.get(0);
        System.out.println(head.val);

        for (TreeNode2 node : nodes) {
          if (node.left != null) queue.offer(node.left);
          if (node.right != null) queue.offer(node.right);
        }
      }
      while (!stack.isEmpty()) {
        System.out.println(stack.pop().val);
      }
    }

    @Override
    public void run() {
      TreeNode2 tree =
          n(20,
              n(8,
                  n(4),
                  n(12, n(10), n(14))),
              n(22, null, n(25)));

      boundaryTraversal(tree);

    }
  }

  static class DensityOfBinaryTreeInOneTraversal implements Runnable{

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

    @Override
    public void run() {
      var t = n(10, n(20, n(30), null), null);
      float d = density(t);
      System.out.println(d);

    }
  }

  static class CalculateDepthFullBinaryTreePreorder implements Runnable {
    private final static char NODE = 'n';
    private final static char LEAF = 'l';

    public static int solve(String treeStr) {
      return helper(treeStr.toCharArray(), new int[]{0});
    }

    private static int helper(char[] nodes, int[] i) {
      i[0]++;
      int curIdx = i[0] - 1;

      if (curIdx == nodes.length || nodes[curIdx] == LEAF) return 0;
      int lh = helper(nodes, i);
      int rh = helper(nodes, i);
      return 1 + Math.max(lh, rh);
    }

    @Override
    public void run() {
      int h = solve("nlnll");
      System.out.println(h);
    }
  }

  static class ModifyBinaryTreeGetPreorderTraversalUsingRightPointers implements Runnable{

    void solve(TreeNode2 root) {
      preOrderProcess(root);
    }

    TreeNode2 preOrderProcess(TreeNode2 root) {
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

    @Override
    public void run() {
      TreeNode2 root =
          n(10,
              n(8, n(3), n(5)),
              n(2));
      solve(root);
      print(root);

    }
  }

  static class DeletionBinaryTree implements Runnable{
    @Override
    public void run() {
      var d = n(12, n(4), n(19));
      var tree = n(13,
          d,
          n(10, n(16), n(9)));

      print(tree);
      solve(tree, d);
      print(tree);
    }


    void solve(TreeNode2 root, TreeNode2 node) {
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

    TreeNode2 parent(TreeNode2 root, TreeNode2 node) {
      if (root == null || node == null || root == node) return null;

      if (root.left == node || root.right == node) return root;
      TreeNode2 p1 = parent(root.left, node);
      if (p1 != null) return p1;
      return parent(root.right, node);
    }
  }

  static class InsertionBinaryTree implements Runnable {
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

    @Override
    public void run() {

    }
  }

  static class AllPossibleBinaryTreesWithInorderTraversal implements Runnable{
    public List<TreeNode2> solve(int[] inorder) {
      List<TreeNode2> rst = new ArrayList<>();
      for (int j : inorder) {
        rst = f(rst, j);
      }
      return rst;
    }

    @Override
    public void run() {
      var s = new AllPossibleBinaryTreesWithInorderTraversal();
      s.solve(new int[]{1, 2, 3})
          .forEach(TreeNode2::print);
    }


    private List<TreeNode2> f(TreeNode2 root, int val) {
      if (root == null) {
        return List.of(n(val));
      }

      var ta = insertAsLeftSubTree(TreeNode2.clone(root), val);
      var tb = insertAsRightMostLeaf(TreeNode2.clone(root), val);
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

}
