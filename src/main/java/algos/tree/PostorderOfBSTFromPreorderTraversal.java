package algos.tree;

public class PostorderOfBSTFromPreorderTraversal {
    /*
  input: [40,30,35,80,100]
  output: [35,30,100,80,40]
   */
  public void solve(int[] preorder){
    h(preorder, 0, preorder.length - 1);
  }

  private void h(int[] preorder, int s, int e){
    if (s > e) return;
    var i = s + 1;
    while (i <= e && preorder[i] < preorder[s]) i++;
    h(preorder, s+1, i-1);
    h(preorder, i, e);
    System.out.println(preorder[s]);
  }

  public static void main(String[] args) {
    var arr = new int[]{40, 30, 35, 80, 100};
    var p = new PostorderOfBSTFromPreorderTraversal();
    p.solve(arr);
  }

}
