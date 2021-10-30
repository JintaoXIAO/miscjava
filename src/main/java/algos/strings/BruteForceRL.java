package algos.strings;

public class BruteForceRL {
  public int solve(String txt, String pat) {
    int M = pat.length();
    int N = txt.length();
    for (int i = N - M; i >= 0 ; i--) {
      int j;
      for (j = 0; j < M && txt.charAt(i+j) == pat.charAt(j); j++);
      if (j == M) return i;
    }
    return txt.length();
  }

  public static void main(String[] args) {
    var b = new BruteForceRL();
    var r = b.solve("ababc", "abc");
    System.out.println(r);
  }
}
