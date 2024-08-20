import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}

		if (N == 1 || N == 2) {
			int sum = 0;
			for (int i = 1; i <= N; i++) {
				sum += arr[i];
			}
			System.out.println(sum);
		}

		else {
			int answer[] = new int[N + 1];
			answer[0] = 0;
			answer[1] = arr[1];
			answer[2] = arr[2] + arr[1];

			for (int i = 3; i <= N; i++) {
				int a;
				int b;

				a = answer[i - 2] + arr[i];
				b = answer[i - 3] + arr[i - 1] + arr[i];

				answer[i] = Math.max(a, b);
			}

			System.out.println(answer[N]);
		}
	}
}