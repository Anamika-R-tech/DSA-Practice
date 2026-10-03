class Solution {

    public int maxCoins(int[] nums) {

        int n = nums.length;

        // Add virtual balloons with value 1
        int[] arr = new int[n + 2];

        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        // dp[left][right] =
        // maximum coins from bursting balloons left to right
        int[][] dp = new int[n + 2][n + 2];

        // length = size of interval
        for (int length = 1; length <= n; length++) {

            for (int left = 1; left + length - 1 <= n; left++) {

                int right = left + length - 1;

                // Try every balloon as the LAST balloon
                for (int k = left; k <= right; k++) {

                    int coins =
                            dp[left][k - 1]
                            + arr[left - 1] * arr[k] * arr[right + 1]
                            + dp[k + 1][right];

                    dp[left][right] = Math.max(
                            dp[left][right],
                            coins
                    );
                }
            }
        }

        return dp[1][n];
    }
}