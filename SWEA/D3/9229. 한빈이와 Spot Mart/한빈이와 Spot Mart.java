import java.util.Scanner;

public class Solution {
	static int arr[];
	static int hand[] = new int[2];
	static int max = -1;
	static int N;
	static int M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			func(0, 0);

			System.out.println("#" + test_case + " " + max);
			max = -1;
		}
	}

	static void func(int count, int idx) {
		if (count == 2) {
			int temp = 0;

			for (int i = 0; i < 2; i++) {
				temp = hand[0] + hand[1];
			}

			if (temp <= M)
				max = Math.max(temp, max);
			return;
		}

		if (idx == N) {
			return;
		}

		hand[count] = arr[idx];
		func(count + 1, idx + 1);
		func(count, idx + 1);
	}
}