import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int arr[] = new int[N];
			int dp[] = new int[N + 1];
			int max = 0;

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			dp[1] = arr[0];

			for (int i = 1; i < N; i++) {
				int count = 1;

				for (int j = 1; j <= i; j++) {
					if (dp[j] != 0 && dp[j] < arr[i]) {
						count = j + 1;
					}

				}
				max = Math.max(max, count);
				if (dp[count] == 0) {
					dp[count] = arr[i];
				} else {
					dp[count] = Math.min(dp[count], arr[i]);
				}
			}
            
			System.out.println("#" + test_case + " " + max);
		}
	}
}