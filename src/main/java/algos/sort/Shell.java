package algos.sort;

public class Shell implements CompareBasedSort{

  @Override
  public <T extends Comparable<T>> void sort(T[] ts) {
    int N = ts.length;
    int h = 1;
    while (h < N/3) h = 3 * h + 1;
    while (h >= 1) {
      for (int i = h; i < N; i++) {
        for (int j = i; j >= h && less(ts[j], ts[j - h]); j -= h) {
          exch(ts, j, j - h);
        }
      }
      h /= 3;
    }
  }
}
