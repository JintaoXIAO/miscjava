package algos;

public class Node {
  public int val;
  public Node next;

  public Node(int val, Node next) {
    this.val = val;
    this.next = next;
  }

  public Node(int val) {
    this(val, null);
  }

  public static void print(Node head) {
    if (head == null) System.out.println("NULL");
    StringBuilder sb = new StringBuilder();
    var p = head;
    sb.append(p.val);
    p = p.next;
    while (p != null) {
      sb.append("->").append(p.val);
      p = p.next;
    }
    System.out.println(sb);
  }

  public static Node c(int ... vs) {
    if (vs.length == 0) return null;
    var head = new Node(vs[0]);
    var p = head;
    for (int i = 1; i < vs.length; i++) {
      p.next = new Node(vs[i]);
      p = p.next;
    }
    return head;
  }

  @Override
  public String toString() {
    return "Node{" +
            "val=" + val +
            '}';
  }

  public static void main(String[] args) {
    var head = Node.c(1, 2, 3, 4, 5);
    Node.print(head);
  }

}
