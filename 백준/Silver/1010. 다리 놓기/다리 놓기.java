import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 0; test_case < T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int comb[][] = new int[M + 1][N + 1];

			for (int i = 1; i <= M; i++) {
				for (int j = 0; j <= i; j++) {
					if(j > N ) {
						break;
					}
					if (i == 1) {
						comb[i][j] = i;
					} else if (j == 0) {
						comb[i][j] = 1;
					} else {
						comb[i][j] = comb[i - 1][j] + comb[i - 1][j - 1];
					}

				}
			}

			System.out.println(comb[M][N]);
		}
	}
}