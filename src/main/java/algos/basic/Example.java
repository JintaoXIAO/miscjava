package algos.basic;

public class Example {
  public static void main(String[] args) {
    QuickUnionPCUF uf = new QuickUnionPCUF(10);

    uf.union(9,0);
    uf.union(7,2);
    uf.union(3, 4);
    uf.union(5, 8);
    uf.union(1,7);
    uf.union(8, 2);
    uf.union(0, 4);

    uf.status();


  }
}
