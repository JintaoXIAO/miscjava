package algos.sort;

import java.util.Arrays;

public class Quick implements CompareBasedSort{

  public static void main(String[] args) {

    var s ="QUICKSORTEXAMPLE";
    Character[] quiz = s.chars().mapToObj(i -> (char) i).toArray(Character[]::new);
    var q = new Quick();
    q.sort(quiz);
    System.out.println(Arrays.toString(quiz));
  }

  @Override
  public <T extends Comparable<T>> void sort(T[] ts) {
    sort(ts, 0, ts.length - 1);
  }

  <T extends Comparable<T>> void sort(T[] ts, int lo, int hi) {
    if (lo >= hi) return;

    int p = partition(ts, lo, hi);
    sort(ts, lo, p - 1);
    sort(ts, p + 1, hi);
  }

  <T extends Comparable<T>> int partition(T[] ts, int lo, int hi) {
    T pivot = ts[lo];

    int p = lo;
    int l = lo + 1, r = hi;
    while (l < r) {
      while (l < r && less(ts[l], pivot)) l++;
      while (l < r && less(pivot, ts[r])) r--;
      if (l < r) exch(ts, l, r);
      else if (less(ts[l], pivot)) {
        exch(ts, lo, l);
        p = l;
      } else {
        exch(ts, lo, l - 1);
        p = l - 1;
      }
    }
    return p;
  }

}
