package algos.sort;

import java.util.Arrays;

public class Merge implements CompareBasedSort {
  @Override
  public <T extends Comparable<T>> void sort(T[] ts) {
    int LAST_INDEX = ts.length - 1;
    T[] aux = Arrays.copyOf(ts, ts.length);
    sort1(ts, aux, 0, LAST_INDEX);
  }

  private <T extends Comparable<T>> void sort1(T[] ts, T[] aux, int lc, int rc) {
    if (lc >= rc) return;
    int M = lc + (rc - lc) / 2;
    sort1(ts, aux, lc, M);
    sort1(ts, aux, M + 1, rc);
    merge(ts, aux, lc, M + 1, rc);
  }

  private <T extends Comparable<T>> void merge(T[] ts, T[] aux, int lc, int m, int rc) {
    if (rc + 1 - lc >= 0) System.arraycopy(ts, lc, aux, lc, rc + 1 - lc);

    for (int i = 0; i < ts.length; i++) {
      int j = lc, k = m + 1;
      while (lc <= m && k <= rc) {
        if (less(aux[j], aux[k]))
          ts[i++] = aux[j++];
        else
          ts[i++] = aux[k++];
      }
      while (j <= m)
        ts[i++] = aux[j++];
      while (k <= rc)
        ts[k++] = aux[k++];
    }
  }
}
