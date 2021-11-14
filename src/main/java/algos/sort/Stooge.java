package algos.sort;

public class Stooge implements CompareBasedSort {
  @Override
  public <T extends Comparable<T>> void sort(T[] ts) {
    sort1(ts, 0, ts.length);
  }

  private <T extends Comparable<T>> void sort1(T[] ts, int l, int h) {
    if (l >= h) return;
    if (less(ts[h],ts[l])) exch(ts, l, h);

    int N = (h - l + 1);
    if (N > 2) {
      sort1(ts, l, h - N);
      sort1(ts, l + N, h);
      sort1(ts, l, h - N);
    }
  }
}
