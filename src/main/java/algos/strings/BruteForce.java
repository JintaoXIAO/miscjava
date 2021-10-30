package algos.strings;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BruteForce {
  private final String pat;

  public BruteForce(String pat) {
    this.pat = pat;
  }

  public int search(String txt) {
    return innerSearch(txt, 0);
  }

  public int innerSearch(String txt, int i) {
    int M = pat.length();
    int N = txt.length();

    for (; i <= N - M; i++) {
      trace(txt,i);

      int j = 0;
      while (j < M && pat.charAt(j) == txt.charAt(i+j)) j++;
      if (j == M) return i;
    }
    return N;
  }

  private void trace(String txt, int i) {
    System.out.println("txt: " + txt);
    String padding = IntStream.range(0,i).boxed().map(j -> " ").collect(Collectors.joining());
    System.out.println("     " + padding + "|||");
    System.out.println("pat: " + padding + pat);
    System.out.println("-------");
  }


  public int count(String txt) {
    int c = 0;
    int N = txt.length();
    int M = pat.length();
    int i = innerSearch(txt, 0);
    while (i < N) {
      c ++;
      i = innerSearch(txt, i + M);
    }
    return c;
  }

  public void searchAll(String txt) {
    int N = txt.length();
    int i = innerSearch(txt, 0);
    while (i < N) {
      System.out.println("occur in index: " + i);
      i = innerSearch(txt, i+1);
    }
  }

  public static void main(String[] args) {
    var bf = new BruteForce("AAAAAAAB");
    bf.searchAll("AAAAAAAAAAAAAAAAAAAAAAAAB");
  }
}
