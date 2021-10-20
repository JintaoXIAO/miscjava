package algos.sort;

import algos.Node;

public class QuickSinglyLinkedList {
  public Node sort(Node head) {
    if (head == null || head.next == null) return head;
    var sentinel = new Node(-1, head);
    return null;
  }

  Node partition(Node sentinel) {
    var n = sentinel.next;
    Node ppre = sentinel;
    Node p = ppre.next;
    Node cpre = n;
    Node c = cpre.next;
    var pivot = n.val;

    while (c != null) {
      if (c.val < pivot) {
        swap(ppre, p, cpre, c);
        var t = c;
        c = p;
        p = t;

        p = p.next;
        c = c.next;
      } else {
        c = c.next;
      }
    }
    return sentinel;
  }

  void swap(Node n1pre, Node n1, Node n2pre, Node n2) {
    Node tmp = n1.next;
    n1.next = n2.next;
    n2.next = tmp;
    n1pre.next = n2;
    n2pre.next = n1;
  }

  public static void main(String[] args) {
    var q = new QuickSinglyLinkedList();
    var head = Node.c(40, 20, 60, 10, 50, 30);

    var wraper = new Node(-1, head);
/*
    q.swap(wraper, head, head.next.next, head.next.next.next);
    Node.print(wraper.next);
*/
    Node.print(q.partition(wraper).next);
  }
}
