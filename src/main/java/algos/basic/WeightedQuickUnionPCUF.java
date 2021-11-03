package algos.basic;

public class WeightedQuickUnionPCUF extends AbstractArrayBasedUF implements UF {
  private int[] sz;

  public WeightedQuickUnionPCUF(int N) {
    super(N);
    count = N;
    sz = new int[N];
    for (int i = 0; i < N; i++) {
      sz[i] = 1;
    }
  }

  @Override
  public int find(int p) {
    int pRoot = p;
    while (pRoot != id[pRoot]) pRoot = id[pRoot];

    while (p != id[p]) {
      int tp = id[p];
      id[p] = pRoot;
      p = tp;
    }
    return p;
  }

  @Override
  public void union(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);
    if (pRoot == qRoot) return;

    if (sz[pRoot] < sz[qRoot]) {
      id[pRoot] = qRoot;
      sz[qRoot]++;
    } else {
      id[qRoot] = pRoot;
      sz[pRoot]++;
    }
    count--;
  }
}
