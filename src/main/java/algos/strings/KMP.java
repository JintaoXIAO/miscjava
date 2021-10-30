package algos.strings;

public class KMP {
  private final String pat;
  private int[][] dfa;

  public KMP(String pat) {
    this.pat = pat;
    int R = 256;
    int M = pat.length();
    this.dfa = new int[R][M];

    int X = 0;
    dfa[pat.charAt(0)][0] = 1;
    for (int j = 1; j < M; j++) {
      for (int c = 0; c < R; c++) {
        if (c == pat.charAt(j))
          dfa[c][j] = j + 1;
        else
          dfa[c][j] = dfa[c][X];
      }
      X = dfa[pat.charAt(j)][X];
    }
  }

  public int search(String txt) {
    return innerSearch(txt, 0);
  }

  public int innerSearch(String txt, int i) {
    int N = txt.length();
    int j = 0, M = pat.length();

    while (i < N && j < M) {
      j = dfa[txt.charAt(i)][j];
      i++;
    }
    if (j == M) return i - M;
    else return N;
  }

  public int count(String txt) {

    int count = 0;
    int i = 0, N = txt.length();
    int j, M = pat.length();
    j = innerSearch(txt, i);

    while (j != N) {
      count ++;
      j = innerSearch(txt, j + M);
    }
    return count;
  }

  public static void main(String[] args) {
    var kmp = new KMP("aba");
    int i = kmp.count("abaabaabaaba");
    System.out.println(i);

  }
}
