package algos;

public class TreeNode2 {
  public int val;
  public TreeNode2 left, right;

  public TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  private TreeNode2 clone1(){
    return n(val,
            left == null ? null : left.clone1(),
            right == null ? null : right.clone1());
  }

  public static TreeNode2 clone(TreeNode2 src) {
    return src.clone1();
  }

  public static void printInOrder(TreeNode2 root) {
    if (root == null) return;
    printInOrder(root.left);
    System.out.print(root.val + " ");
    printInOrder(root.right);
  }

  public static TreeNode2 n(int val, TreeNode2 left, TreeNode2 right){
    return new TreeNode2(val, left, right);
  }

  public static TreeNode2 n(int val){
    return n(val, null, null);
  }

  public static void main(String[] args) {
    var t1 = n(1,
            n(2,
                    n(4),
                    n(5,
                            n(6),
                            n(7))),
            n(3));
    var t2 = clone(t1);
    //System.out.printf("%0s\n", "<<<<");
    printInOrder(t1);
  }
}
