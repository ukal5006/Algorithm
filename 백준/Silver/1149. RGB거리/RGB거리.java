import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int map[][] = new int[N][3];
		int sum[][] = new int[N][3];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 0) {
					sum[i][j] = map[i][j];
				} else {
					int min;
					if (j == 0) {
						min = Math.min(sum[i - 1][1], sum[i - 1][2]);
					} else if (j == 1) {
						min = Math.min(sum[i - 1][0], sum[i - 1][2]);
					} else {
						min = Math.min(sum[i - 1][1], sum[i - 1][0]);
					}
					sum[i][j] += map[i][j] + min;
				}
			}
		}

		int answer = Math.min(sum[N - 1][0], sum[N - 1][1]);
		answer = Math.min(answer, sum[N - 1][2]);

		System.out.println(answer);

	}
}