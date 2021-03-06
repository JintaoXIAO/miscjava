package algos.basic;

import java.util.Arrays;

public abstract class AbstractArrayBasedUF implements UF, Stat{
  protected int[] id;
  protected int count;

  public AbstractArrayBasedUF(int N) {
    count = N;
    id = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  public int count() {
    return count;
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  public abstract int find(int p);

  public abstract void union(int p, int q);

  @Override
  public void status() {
    System.out.println("status: " + Arrays.toString(id));
  }
}
