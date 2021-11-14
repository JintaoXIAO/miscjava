package algos.sort;

public class Selection implements CompareBasedSort {
  public <T extends Comparable<T>> void sort(T[] ts) {
    int N = ts.length;
    for (int i = 0; i < N; i++) {
      int min = i;
      for (int j = i+1; j <N ; j++)
        if (less(ts[j], ts[min])) min = j;
      exch(ts, i, min);
    }
  }
}
