package algos.strings;


/*exercise: 5.3.4*/
public class ConsecutiveBlanks {
  public int solveBF(String txt, int m) {
    for (int i = 0; i <= txt.length() - m; i++) {
      int j;
      for (j = 0; j < m && txt.charAt(i + j) == ' '; j++) ;
      if (j == m) return i;
    }
    return txt.length();
  }

  public static void main(String[] args) {
    var c = new ConsecutiveBlanks();
    var r = c.solveBF("ab     cde", 5);
    System.out.println(r);
  }
}
