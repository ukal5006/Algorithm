import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int dp[][] = new int[n][n];
		dp[0][0] = sc.nextInt();

		int max = dp[0][0];

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					dp[i][j] = sc.nextInt() + dp[i - 1][j];
				} else if (j == i) {
					dp[i][j] = sc.nextInt() + dp[i - 1][j - 1];
				} else {
					dp[i][j] = sc.nextInt() + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
				}

				if (i == n - 1) {
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		System.out.println(max);
	}
}