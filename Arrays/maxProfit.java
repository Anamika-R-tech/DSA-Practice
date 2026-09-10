import java.util.*;

public class maxProfit {

    public static int maxProfit(int[] profit, int K) {

        int n = profit.length;

        int[][] dp = new int[n + 1][K + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {

            for (int k = 1; k <= K; k++) {

                // Don't take current project
                dp[i][k] = dp[i - 1][k];

                // Take current project
                if (i == 1) {
                    if (k == 1) {
                        dp[i][k] = Math.max(dp[i][k], profit[0]);
                    }
                } else if (dp[i - 2][k - 1] != Integer.MIN_VALUE) {

                    dp[i][k] = Math.max(
                        dp[i][k],
                        profit[i - 1] + dp[i - 2][k - 1]
                    );
                }
            }
        }

        return dp[n][K] == Integer.MIN_VALUE ? -1 : dp[n][K];
    }

    public static void main(String[] args) {

        int[] profit = {10, 1, 1, 10};
        int K = 2;

        System.out.println(maxProfit(profit, K));
    }
}