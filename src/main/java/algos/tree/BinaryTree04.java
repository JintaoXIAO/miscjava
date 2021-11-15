package algos.tree;

/**
 * @see "https://www.geeksforgeeks.org/calculate-depth-full-binary-tree-preorder/"
 */
public class BinaryTree04 {
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

  public static void main(String[] args) {
    int h = BinaryTree04.solve("nlnll");
    System.out.println(h);
  }

}
