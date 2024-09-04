import java.util.Scanner;

public class Solution {
	static int N;
	static int L;
	static int score[];
	static int kcal[];
	static int maxScore;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			L = sc.nextInt();
			score = new int[N];
			kcal = new int[N];
			maxScore = 0;

			for (int i = 0; i < N; i++) {
				score[i] = sc.nextInt();
				kcal[i] = sc.nextInt();
			}

			func(0, 0, 0);

			System.out.println("#" + test_case + " " + maxScore);

		}
	}

	static void func(int idx, int sumScore, int sumKcal) {
		if (sumKcal <= L) {
			maxScore = Math.max(sumScore, maxScore);
		} else {
			return;
		}

		if (idx == N) {
			return;
		}

		func(idx + 1, sumScore + score[idx], sumKcal + kcal[idx]);
		func(idx + 1, sumScore, sumKcal);
	}
}