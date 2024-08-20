import java.util.Scanner;

public class Main {
	static int X;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		int ans = dp();
		System.out.println(ans);
	}

	static int dp() {
		int[] memo = new int[X + 1];

		for (int i = 2; i <= X; i++) {
			memo[i] = memo[i - 1] + 1;

			if (i % 3 == 0) {
				memo[i] = Math.min(memo[i], memo[i / 3] + 1);
			}

			if (i % 2 == 0) {
				memo[i] = Math.min(memo[i], memo[i / 2] + 1);
			}
		}

		return memo[X];
	}
}