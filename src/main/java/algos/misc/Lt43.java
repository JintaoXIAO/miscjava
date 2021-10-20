package algos.misc;


public class Lt43 {
  class Solution {

    public String multiply(String num1, String num2) {
      if ("0".equals(num1) || "0".equals(num2)) return "0";

      int[] m = new int[num1.length() + num2.length()];
      for (int i = num1.length() - 1; i >=0; i--) {
        for (int j = num2.length() - 1; j >= 0; j--) {
          int a = num1.charAt(i) - '0';
          int b = num2.charAt(j) - '0';
          int t = a * b + m[i+j+1];
          m[i+j+1] = t % 10;
          m[i + j] += t / 10;
        }
      }
      StringBuilder sb = new StringBuilder();
      boolean b = true;
      for (int i = 0; i < m.length; i++) {
        if (m[i] == 0 && b) continue;
        else {
          b = false;
          sb.append(m[i]);
        }
      }
      return sb.toString();
    }
  }
}
