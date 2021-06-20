package algos;

/*
A-Z,a-z,0-9,+,/
 */
public class Base64 {

  private static int SHIFT_2 = 2;
  private static int SHIFT_4 = 4;
  private static int SHIFT_6 = 6;
  private static int MASK_2 = 0x03;
  private static int MASK_4 = 0x0f;
  private static int MASK_6 = 0x3f;
  private static char[] b64 = {
      'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
      'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/',
  };

  public static String encode(String msg) {
    int i = 0;
    StringBuilder sb = new StringBuilder();
    while (i + 2 < msg.length()) {
      char a = msg.charAt(i), b = msg.charAt(i + 1), c = msg.charAt(i + 2);
      sb.append(c(a, b, c));
      i = i + 3;
    }
    if (i + 1==msg.length()) {
      sb.append(c(msg.charAt(i)));
    }
    if (i + 2==msg.length()) {
      sb.append(c(msg.charAt(i), msg.charAt(i + 1)));
    }

    return sb.toString();
  }

  private static String c(int a) {
    return p(a, 0x00, 0x00, 2);
  }

  private static String c(int a, int b) {
    return p(a, b, 0x00, 1);
  }

  private static String c(int a, int b, int c) {
    return p(a, b, c, 0);
  }

  private static String p(int a, int b, int c, int n) {
    StringBuilder sb = new StringBuilder();
    int i,j,k,l;
    i = a >> SHIFT_2;
    j = ((a & MASK_2) << SHIFT_4) | (b >> SHIFT_4);
    k = ((b & MASK_4) << SHIFT_2) | (c >> SHIFT_6);
    l = c & MASK_6;
    switch (n){
      case 0:
        sb.append(b64[i]).append(b64[j]).append(b64[k]).append(b64[l]);
        break;
      case 1:
        sb.append(b64[i]).append(b64[j]).append(b64[k]).append('=');
        break;
      case 2:
        sb.append(b64[i]).append(b64[j]).append('=').append('=');
        break;
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String s = "hello";
    System.out.println(encode(s));
  }
}
