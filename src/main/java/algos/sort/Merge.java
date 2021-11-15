package algos.sort;

import java.util.Arrays;

public class Merge implements CompareBasedSort {
  @Override
  public <T extends Comparable<T>> void sort(T[] ts) {
    int LAST_INDEX = ts.length - 1;
    sort1(ts, 0, LAST_INDEX);
  }

  private <T extends Comparable<T>> void sort1(T[] ts, int lc, int rc) {
    if (lc >= rc) return;
    int M = lc + (rc - lc) / 2;
    sort1(ts, lc, M);
    sort1(ts, M+1, rc);
    merge(ts, lc, M+1, rc);
  }

  private <T extends Comparable<T>> void merge(T[] ts, int lc, int m, int rc) {
    T[] tmp = Arrays.copyOf(ts, ts.length);
    for (int i = 0; i < ts.length; i++) {
      int j = lc, k = m + 1;
      while (lc <= m && k <= rc) {
        if (less(tmp[j], tmp[k]))
          ts[i++] = tmp[j++];
        else
          ts[i++] = tmp[k++];
      }
      while (j <= m)
        ts[i++] = tmp[j++];
      while (k <= rc)
        ts[k++] = tmp[k++];
    }
  }
}
