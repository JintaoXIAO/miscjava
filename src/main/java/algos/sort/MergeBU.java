package algos.sort;

import java.util.Arrays;

public class MergeBU implements CompareBasedSort{
  @Override
  public <T extends Comparable<T>> void sort(T[] ts) {
    int N = ts.length;
    T[] aux = Arrays.copyOf(ts, N);

    for (int len = 1; len < N; len *= 2) {
      for (int lo = 0; lo < N; lo += 2 * len) {
        int mid = lo + len - 1;
        int hi = Math.min(lo + 2 * len - 1, N - 1);
        merge(ts, aux, lo, mid, hi);
      }
    }
  }

  private <T extends Comparable<T>> void merge(T[] ts, T[] aux, int lo, int mid, int hi) {
    if (hi + 1 - lo >= 0) System.arraycopy(ts, lo, aux, lo, hi + 1 - lo);

    int i = lo, j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      if (i > mid) ts[k] = aux[j++];
      else if (j > hi) ts[k] = aux[i++];
      else if (less(aux[i], aux[j])) ts[k] = aux[i++];
      else ts[k] = aux[j++];
    }
  }

  private <T extends Comparable<T>> void fastMerge(T[] ts, T[] aux, int lo, int mid, int hi) {
    if (mid + 1 - lo >= 0) System.arraycopy(ts, lo, aux, lo, mid + 1 - lo);

    for (int i = mid+1; i <= hi ; i++) {
      aux[i] = ts[hi + mid + 1 - i];
    }

    int i = lo, j = hi;
    for (int k = lo; k <= hi; k++) {
      if (less(aux[i],aux[j])) ts[k] = aux[i++];
      else ts[k] = aux[j--];
    }
  }
}
