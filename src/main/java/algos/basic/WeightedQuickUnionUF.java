package algos.basic;

public class WeightedQuickUnionUF extends AbstractArrayBasedUF implements UF{
  private int[] sz;
   public WeightedQuickUnionUF(int N) {
    super(N);
    count = N;
    sz = new int[N];
    for (int i = 0; i < N; i++) {
      sz[i] = 1;
    }
  }

  @Override
  public int find(int p) {
    while (p != id[p]) p = id[p];
    return p;
  }

  @Override
  public void union(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);
    if (pRoot == qRoot) return;

    if (sz[pRoot] < sz[qRoot]) {
      id[pRoot] = qRoot;
      sz[qRoot] ++;
    } else {
      id[qRoot] = pRoot;
      sz[pRoot] ++;
    }
    count --;
  }
}
