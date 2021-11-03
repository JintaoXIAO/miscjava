package algos.basic;

/*
1.5.12
quick union with path compress
 */
public class QuickUnionPCUF extends AbstractArrayBasedUF implements UF {
  public QuickUnionPCUF(int N) {
    super(N);
  }

  @Override
  public int find(int p) {
    int pRoot = p;
    while (pRoot != id[pRoot]) pRoot = id[pRoot];

    while (p != pRoot) {
      int tp = id[p];
      id[p] = pRoot;
      p = tp;
    }
    return pRoot;
  }

  @Override
  public void union(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);
    if (pRoot == qRoot) return;

    id[pRoot] = qRoot;
    count--;
  }
}
