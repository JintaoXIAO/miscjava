package algos.misc;

/*

  accounts: 1..n
  balance long[]: 0-indexed
  accNum: 1..n

 */

public class Lt2043 {
  class Bank {

    private final long[] balance;

    public Bank(long[] balance) {
      this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
      if (invalidAccount(account1) || !invalidAccount(account2)) {
        return false;
      }

      if (withdraw(account1, money)) {
        return deposit(account2, money);
      }
      return false;
    }

    public boolean deposit(int account, long money) {
      if (invalidAccount(account)) return false;
      this.balance[account-1] += money;
      return true;
    }

    public boolean withdraw(int account, long money) {
      if (invalidAccount(account)) return false;
      if (this.balance[account-1] < money) return false;
      this.balance[account - 1] -= money;
      return true;
    }

    private boolean invalidAccount(int account) {
      return account < 1 || account > this.balance.length;
    }
  }

}
