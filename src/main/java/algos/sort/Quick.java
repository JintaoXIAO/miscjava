package algos.sort;

public class Quick implements CompareBasedSort{
  @Override
  public <T extends Comparable<T>> void sort(T[] ts) {
    sort(ts, 0, ts.length - 1);
  }

  <T extends Comparable<T>> void sort(T[] ts, int lo, int hi) {
    if (lo >= hi) return;

    int p = partition(ts, lo, hi);
    sort(ts, lo, p -1);
    sort(ts, p + 1, hi);
  }

  <T extends Comparable<T>> int partition(T[] ts, int lo, int hi) {
    T pivot = ts[lo];

    int p = lo;
    int l = 1, r = hi;
    while (l <= r && r > 0) {
      while (l <= r && less(ts[l], pivot)) l++;
      while (l <= r && less(pivot, ts[r])) r--;
      if (l < r) exch(ts, l, r);
      else if (l == r) {
        if (less(ts[l], pivot)) {
          exch(ts, l, 0);
          p = l;
        } else {
          p = l - 1;
        }
      } else {
        exch(ts, hi, 0);
        p = hi;
      }
    }
    return p;
  }

}
