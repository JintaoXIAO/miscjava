package algos.tree;

import algos.TreeNode2;
import algos.misc.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import static algos.TreeNode2.n;

public class BinaryTree06 {

  public static void main(String[] args) {
    TreeNode2 tree =
            n(20,
                    n(8,
                            n(4),
                            n(12, n(10), n(14))),
                    n(22, null, n(25)));

    boundaryTraversal(tree);
  }

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
}
