package algos.basic;

public class WeightedQuickFindUF extends AbstractArrayBasedUF implements UF {
  private int[] sz;

  public WeightedQuickFindUF(int N) {
    super(N);
    count = N;
    sz = new int[N];
    for (int i = 0; i < N; i++) {
      sz[i] = 1;
    }
  }

  @Override
  public int find(int p) {
    return id[p];
  }

  @Override
  public void union(int p, int q) {
    int N = id.length;
    for (int i = 0; i < N; i++) {
      if (id[i] == p) id[i] = q;
    }
    int pRoot = id[p];
    while (p != pRoot) {
      id[p] = q;
      p = id[pRoot];
    }
  }
}
