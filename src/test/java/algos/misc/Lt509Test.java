package algos.misc;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test
public class Lt509Test {
  public void test1() {
    var s =new Lt509().new Solution();
    assertEquals(s.fib(0), 0);
    assertEquals(s.fib(1), 1);
    assertEquals(s.fib(2),1);
    assertEquals(s.fib(4),3);
  }
}