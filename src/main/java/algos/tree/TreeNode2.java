package algos.tree;

public class TreeNode2 implements Cloneable{
  int val;
  TreeNode2 left, right;

  public TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  @Override
  protected Object clone() {
    return this.clone1();
  }

  private TreeNode2 clone1(){
    return n(val,
            left == null ? null : left.clone1(),
            right == null ? null : right.clone1());
  }

  public static void print(TreeNode2 root) {
    print(root, 1);
  }

  private static void print(TreeNode2 root, int padding) {
    if (root == null) {
      System.out.printf("%"+ padding + "s\n", "-");
      return;
    }
    System.out.printf(("%" + padding + "s\n"), root.val);
    print(root.left, padding + 3);
    print(root.right, padding + 3);
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
    var t2 = t1.clone();
    //System.out.printf("%0s\n", "<<<<");
    print(t1);
  }
}
