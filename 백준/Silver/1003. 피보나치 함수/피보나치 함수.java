import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Answer dp[] = new Answer[41];
		dp[0] = new Answer(1, 0);
		dp[1] = new Answer(0, 1);

		for (int i = 2; i <= 40; i++) {
			dp[i] = new Answer(dp[i - 1].a + dp[i - 2].a, dp[i - 1].b + dp[i - 2].b);
		}

		for (int i = 0; i < N; i++) {
			int input = sc.nextInt();
			System.out.println(dp[input].a + " " + dp[input].b);
		}

	}

	static class Answer {
		int a, b;

		public Answer(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
}