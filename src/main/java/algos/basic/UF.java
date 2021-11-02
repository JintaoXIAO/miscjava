package algos.basic;

public interface UF {
  int count();
  int find(int p);
  void union(int p, int q);
  boolean connected(int p, int q);
}
