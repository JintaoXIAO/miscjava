package algos.misc;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test
public class Lt322Test {
  Lt322.Solution s = new Lt322().new Solution();

  public void test() {
    assertEquals(
        s.coinChange(new int[]{1, 2, 5},11),3
    );
    assertEquals(
        s.coinChange(new int[]{2}, 3), -1
    );

    assertEquals(s.coinChange(new int[]{1}, 0), 0);

  }
}