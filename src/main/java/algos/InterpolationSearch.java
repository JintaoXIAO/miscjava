package algos;

public class InterpolationSearch {
  public int search(int k, int[] sorted){
    if (sorted==null || sorted.length==0) {
      throw new IllegalArgumentException();
    }
    if (k < sorted[0] || k > sorted[sorted.length - 1]) {
      return -1;
    }
    return h(k, sorted, 0, sorted.length - 1);
  }

  private int h(int k, int[] sorted, int lo, int hi) {
    if (lo > hi) {
      return -1;
    }
    if (lo == hi) return sorted[lo]==k ? lo:-1;

    int pos = lo + (k - sorted[lo]) * (hi - lo) / (sorted[hi] - sorted[lo]);
    if (k == sorted[pos]) return pos;
    if (k < sorted[pos]) return h(k, sorted, lo, pos - 1);
    else return h(k, sorted, pos + 1, hi);
  }

  public static void main(String[] args) {
    var is = new InterpolationSearch();
    //int i = is.search(8, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10});
    int i = is.search(1,new int[]{0,1});
    System.out.println(i);
  }
}
