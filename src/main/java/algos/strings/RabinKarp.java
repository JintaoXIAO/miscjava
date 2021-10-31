package algos.strings;

public class RabinKarp {
  private String pat;
  private long patHash;
  private int M;
  private long Q;
  private int R = 256;
  private long RM;

  public RabinKarp(String pat) {
    this.pat = pat;
    this.M = pat.length();
    Q = longRandomPrime();
    RM = 1;
    for (int i = 0; i < M - 1; i++) {
      RM = (R * RM) % Q;
    }
    patHash = hash(pat, M);
  }

  private long hash(String pat, int m) {
    return 0;
  }

  private long longRandomPrime() {
    return 0;
  }

  private int search(String txt) {
    int N = txt.length();
    long txtHash = hash(txt, M);
    if (patHash == txtHash) return 0;
    for (int i = M; i < N; i++) {
      txtHash = (txtHash + Q - RM * txt.charAt(i - M)) % Q;
      txtHash = (txtHash * R + txt.charAt(i)) % Q;
      if (patHash == txtHash && check(i - M  +1)) return i -M + 1;
    }
    return N;
  }

  private boolean check(int i) {
    return true;
  }
}
