package algos.tree;

public class PrintPostOrderTraversalFromGivenInorderAndPreorderTraversals {
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

  public static void main(String[] args) {
    var p = new PrintPostOrderTraversalFromGivenInorderAndPreorderTraversals();
    var inorder = new int[]{4,2,5,1,3,6};
    var preorder = new int[]{1, 2, 4, 5, 3, 6};
    p.solve(inorder, preorder);
  }
}
