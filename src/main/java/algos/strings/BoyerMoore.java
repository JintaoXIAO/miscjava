package algos.strings;

/*
txt: FINDINAHAYSTACKNEEDLE
pat: NEEDLE

FINDINAHAYSTACKNEEDLE
NEEDLE('N' not existed in NEEDLE, so we just skip the whole length to next position)
      NEEDLE('T' not too, same as before step)
            NEEDLE
              NEEDLE
               NEEDLE


 */
public class BoyerMoore {
  private final String pat;
  private final int[] right;

  public BoyerMoore(String pat) {
    this.pat = pat;
    int M = pat.length();
    int R = 256;
    right = new int[R];
    for (int c = 0; c < R; c++) {
      right[c] = -1;
    }
    for (int j = 0; j < M; j++) {
      right[pat.charAt(j)] = j;
    }
  }

  public int search(String txt) {
    int N = txt.length();
    int M = pat.length();
    int skip;
    for (int i = 0; i <= N - M; i += skip) {
      skip = 0;
      for (int j = M - 1; j >= 0; j--) {
        if (pat.charAt(j) != txt.charAt(i+j)){
          skip = j - right[txt.charAt(i+j)];
          if (skip < 1) skip = 1;
          break;
        }
      }
      if (skip == 0) return i;
    }
    return N;
  }

  public int innerSearch(String txt, int i) {
    int N = txt.length();
    int M = pat.length();
    int skip;
    for (; i <= N - M; i += skip) {
      skip = 0;
      for (int j = M - 1; j >= 0; j--) {
        if (pat.charAt(j) != txt.charAt(i+j)){
          skip = j - right[txt.charAt(i+j)];
          if (skip < 1) skip = 1;
          break;
        }
      }
      if (skip == 0) return i;
    }
    return N;
  }

  public int count(String txt) {
    int count = 0;
    int j = innerSearch(txt, 0);
    int N = txt.length();
    int M = pat.length();
    while (j < N){
      count ++;
      j = innerSearch(txt, j + M);
    }
    return count;
  }

  public static void main(String[] args) {
    var bm = new BoyerMoore("abc");
    var i = bm.count("abcabcababcabc");
    System.out.println(i);
  }

}
