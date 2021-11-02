package algos.basic;
/*
1.5.12
quick union with path compress
 */
public class QuickUnionPCUF extends AbstractArrayBasedUF implements UF{
  public QuickUnionPCUF(int N) {
    super(N);
  }

  @Override
  public int find(int p) {
    while(p != id[p]) p = id[p];
    return p;
  }

  @Override
  public void union(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);
    if (pRoot == qRoot) return;

    id[pRoot] = qRoot;
    count --;
  }
}
