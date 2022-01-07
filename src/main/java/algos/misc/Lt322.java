package algos.misc;

import java.util.Arrays;

public class Lt322 {
  class Solution {
    public int coinChange(int[] coins, int amount) {
      int[] dp = new int[amount + 1];
      Arrays.fill(dp, -1);

      for (int coin : coins) {
        /* edge case1 :: amount maybe less than some coin */
        if (coin < dp.length) dp[coin] = 1;
      }

      dp[0] = 0;
      for (int i = 1; i <= amount; i++) {
        helper(coins, i, dp);
      }

      return dp[amount];
    }

    private void helper(int[] coins, int amount, int[] dp) {
      for (int c : coins) {
        if (amount >= c
            && dp[amount - c] != -1
            && (dp[amount] == -1 || dp[amount] > dp[amount - c] + 1))
          dp[amount] = dp[amount - c] + 1;
      }
    }
  }
}
