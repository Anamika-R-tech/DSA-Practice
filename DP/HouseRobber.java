import java.util.Scanner;

/*
 * Problem: House Robber
 * LeetCode: 198
 * Difficulty: Medium
 * Topic: 1D Dynamic Programming
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class HouseRobber {

    public static int rob(int[] nums) {

        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1],
                    nums[i] + dp[i - 2]);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of houses: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter money in each house:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Maximum money: " + rob(nums));

        sc.close();
    }
}