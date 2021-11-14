package algos.sort;

public class BinaryInsertion implements CompareBasedSort{
  @Override
  public <T extends Comparable<T>> void sort(T[] ts) {
    int N = ts.length;
    for (int i = 1; i < N; i++) {
      int j = bs(ts,0,i-1, ts[i]);
      int k;
      for (k = i; k > j; k--) {
        ts[k] = ts[k - 1];
      }
      ts[k] = ts[i];
    }
  }

  private <T extends Comparable<T>> int bs(T[] ts, int l, int h, T t) {
    // "l > h" could not happen
    if (l == h) {
      if (less(ts[l], t)) return l + 1;
      else return l;
    }
    if (less(ts[h], t)) return h + 1;
    if (less(t,ts[l])) return l;
    int m = l + (h - l) / 2;
    if (eq(ts[m], t)) return m + 1;
    if (less(ts[m], t)) return bs(ts, m + 1, h, t);
    else return bs(ts, l, m, t);
  }

  <T extends Comparable<T>> boolean eq(T t1, T t2) {
    return t1.compareTo(t2) == 0;
  }
}
