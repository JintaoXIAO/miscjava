package algos.misc;

public class Lt374 {
  public static void main(String[] args) {
    var s = new Solution(17);
    int r = s.guessNumber(56);
    System.out.println(r);
  }


  static class Solution extends GuessGame {
    public Solution(int answer) {
      super(answer);
    }

    public int guessNumber(int n) {
      int l = 1, r = n;
      int m = l + (r - l) / 2;
      int t = guess(m);
      while (t != 0) {
        if (t == 1) r = m - 1;
        else l = m + 1;
        m = l + (r - l) / 2;
        t = guess(m);
      }
      return m;
    }
  }

  private static class GuessGame {

    private int answer;

    public GuessGame(int answer) {
      this.answer = answer;
    }

    int guess(int num) {
      return Integer.compare(num, answer);
    }
  }
}
