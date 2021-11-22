package algos.sort;

public class Quick3 implements CompareBasedSort{
  @Override
  public <T extends Comparable<T>> void sort(T[] ts) {

  }

  <T extends Comparable<T>> void sort(T[] ts, int lo, int hi) {
    if (lo >= hi) return;

    int pi = randomSelectPovot(lo, hi);
    exch(ts, lo, pi);

    T pivot = ts[lo];

    int lt = 0, gt = hi;
    int i = lo + 1;
    while (i <= hi) {
      if (less(ts[i], pivot)) {
        exch(ts, i, lo);
        lt++;
        i++;
      } else if (less(ts[i],pivot)){
        exch(ts, i, gt);
        gt --;
      } else {
        i++;
      }
    }
    sort(ts, lo, lt - 1);
    sort(ts, gt + 1, hi);
  }

  int randomSelectPovot(int lo, int hi) {
    return lo;
  }
}
