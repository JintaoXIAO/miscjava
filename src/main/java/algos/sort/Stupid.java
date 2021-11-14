package algos.sort;

public class Stupid implements CompareBasedSort {
  @Override
  public <T extends Comparable<T>> void sort(T[] ts) {
    int N = ts.length;
    for (int i = 1; i < N; i++) {
      if (less(ts[i],ts[i-1])) {
        exch(ts,i,i-1);
        sort(ts);
      }
    }
  }
}
