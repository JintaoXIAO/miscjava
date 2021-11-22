package algos.sort;

public class QuickDualPivot implements CompareBasedSort{
  @Override
  public <T extends Comparable<T>> void sort(T[] ts) {

  }

  <T extends Comparable<T>> void sort(T[] ts, int lo, int hi) {
    if (lo >= hi) return;

    if (less(ts[hi], ts[lo])) exch(ts, lo, hi);

    int lt = lo + 1, gt = hi - 1;
    int i = lo + 1;
    while (lt <= gt) {
      if (less(ts[i], ts[lo])) exch(ts, i++, lt++);
      else if (less(ts[hi], ts[i])) exch(ts, i, gt--);
      else  i++;
    }
    exch(ts, lo, --lt);
    exch(ts, hi, ++gt);

    sort(ts, lo, lt - 1);
    if (less(ts[lt], ts[gt])) sort(ts, lt + 1, gt - 1);
    sort(ts, gt + 1, hi);
  }
}
