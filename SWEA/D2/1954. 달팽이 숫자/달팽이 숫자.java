import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			if (N == 1) {
				System.out.println("#" + test_case);
				System.out.println(1);
				continue;
			}
			int arr[][] = new int[N][N];
			arr[0][0] = 1;
			int di[] = { 0, 1, 0, -1 };
			int dj[] = { 1, 0, -1, 0 };
			int dIdx = 0;
			int i = 0;
			int j = 0;
			int count = 1;

			while (true) {
				if (i + di[dIdx % 4] < N && i + di[dIdx % 4] >= 0 && j + dj[dIdx % 4] < N && j + dj[dIdx % 4] >= 0
						&& arr[i + di[dIdx % 4]][j + dj[dIdx % 4]] == 0) {
					count++;
					arr[i + di[dIdx % 4]][j + dj[dIdx % 4]] = count;
					i += di[dIdx % 4];
					j += dj[dIdx % 4];
					if (count == N * N)
						break;
				} else {
					dIdx++;
				}
			}

			System.out.println("#" + test_case);
			for (int q = 0; q < N; q++) {
				for (int w = 0; w < N; w++) {
					System.out.print(arr[q][w] + " ");
				}
				System.out.println();
			}

		}
	}
}