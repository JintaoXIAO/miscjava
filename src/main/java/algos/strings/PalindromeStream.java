package algos.strings;

import java.util.Random;

public class PalindromeStream {
  private final String txt;
  private final int R = 256;
  private final int P = prime();

  public PalindromeStream(String txt) {
    this.txt = txt;
  }

  public void printPalindrome() {
    int txtHash = 0, txtHashRL = 0;
    for (int j = 0; j < txt.length(); j++) {
      txtHash = ((txtHash * R) % P + txt.charAt(j)) % P;
      txtHashRL = (txtHashRL + (txt.charAt(j) * powR(R, j, P)) % P) % P;

      if (txtHash == txtHashRL) {
        System.out.println("find palindrome: " + txt.substring(0, j + 1));
      }
    }
  }

  private int powR(int a, int i, int d) {
    int r = 1;
    while (i > 0) {
      r = r * a;
      r %= d;
      i--;
    }
    return r;
  }

  private int prime() {
    Random random = new Random();
    random.setSeed(System.currentTimeMillis());
    return random.nextInt(10_000);
  }

  public static void main(String[] args) {
    var p = new PalindromeStream("abacacaba");
    p.printPalindrome();

  }
}
