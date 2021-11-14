package algos.sort;

public class InsertionX implements CompareBasedSort {
  public <T extends Comparable<T>> void sort(T[] ts) {
    int N = ts.length;
    int exchanges = 0;

    for (int i = N-1; i >0 ; i--) {
      if (less(ts[i], ts[i - 1])) {
        exch(ts, i, i - 1);
        exchanges ++;
      }
    }
    if (exchanges == 0) return;

    for (int i = 2; i < N; i++) {
      T t = ts[i];
      int j = i;
      while (less(t, ts[j-1])){
        ts[j] = ts[j-1];
        j--;
      }
      ts[j] = t;
    }
  }
}
