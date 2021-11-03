package algos.sort;

public interface CompareBasedSortOps {
  default <T extends Comparable<T>> void exch(T[] ts, int i, int j) {
    T t = ts[i];
    ts[i] = ts[j];
    ts[j] = t;
  }

  default <T extends Comparable<T>> boolean less(T t1, T t2) {
    return t1.compareTo(t2) < 0;
  }

  default <T extends Comparable<T>> boolean isSorted(T[] ts) {
    for (int i = 1; i < ts.length; i++)
      if (less(ts[i], ts[i-1])) return false;
    return true;
  }

  <T extends Comparable<T>> void sort(T[] ts);
}
