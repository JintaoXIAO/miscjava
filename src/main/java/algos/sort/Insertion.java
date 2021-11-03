package algos.sort;

public class Insertion implements CompareBasedSortOps {

  @Override
  public <T extends Comparable<T>> void sort(T[] ts) {
    int N = ts.length;
    for (int i = 1; i < N; i++) {
      for (int j = i; less(ts[j], ts[j - 1]); j--)
        exch(ts, j, j - 1);
    }
  }
}
