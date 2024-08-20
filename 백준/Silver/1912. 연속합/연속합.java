import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int dp[] = new int[n];
		int max = -1000;

		for (int i = 0; i < n; i++) {
			dp[i] = sc.nextInt();
			if (i > 0) {
				dp[i] = Math.max(dp[i], dp[i - 1] + dp[i]);
			}
			max = Math.max(dp[i], max);
		}

		System.out.println(max);
	}
}