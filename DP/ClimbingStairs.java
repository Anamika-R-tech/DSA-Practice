import java.util.Scanner;

/*
 * Problem: Climbing Stairs
 * LeetCode: 70
 * Difficulty: Easy
 * Topic: 1D Dynamic Programming
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class ClimbingStairs {

    public static int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of stairs: ");
        int n = sc.nextInt();

        System.out.println("Number of ways: " + climbStairs(n));

        sc.close();
    }
}