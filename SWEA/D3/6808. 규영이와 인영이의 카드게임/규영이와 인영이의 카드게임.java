import java.util.Scanner;

public class Solution {
	static int winCount;
	static int loseCount;
	static int kyu[] = new int[10];
	static int eun[] = new int[10];
	static int state[] = new int[10];
	static boolean used[] = new boolean[10];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			boolean check[] = new boolean[19];
			int idx = 1;
			winCount = 0;
			loseCount = 0;

			for (int j = 1; j <= 9; j++) {
				kyu[j] = sc.nextInt();
				check[kyu[j]] = true;
			}

			for (int j = 1; j <= 18; j++) {
				if (!check[j]) {
					eun[idx++] = j;
				}

				if (idx == 10) {
					break;
				}
			}

			func(1);
			System.out.println("#" + test_case + " " + winCount + " " + loseCount);

		}
	}

	static void func(int idx) {
		if (idx == 10) {
			int sum = 0;
			for (int i = 1; i <= 9; i++) {
				if (kyu[i] > state[i]) {
					sum -= (kyu[i] + state[i]);
				} else {
					sum += kyu[i] + state[i];
				}
			}
			if (sum > 0) {
				loseCount++;
			} else if (sum < 0) {
				winCount++;
			}
			return;
		}

		for (int i = 1; i <= 9; i++) {
			if (!used[i]) {
				used[i] = true;
				state[idx] = eun[i];
				func(idx + 1);
				used[i] = false;
			}
		}
	}
}