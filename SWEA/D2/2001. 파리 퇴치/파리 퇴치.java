import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int max = 0;
			int N = sc.nextInt();
			int M = sc.nextInt();
			int arr[][] = new int[N + 1][N + 1];

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					arr[i][j] = arr[i][j - 1] + arr[i - 1][j] - arr[i - 1][j - 1] + sc.nextInt();
				}
			}

			for (int i = M; i <= N; i++) {
				for (int j = M; j <= N; j++) {
					int sum = arr[i][j] - arr[i - M][j] - arr[i][j - M] + arr[i - M][j - M];
					max = Math.max(sum, max);
				}
			}
			System.out.print("#" + test_case + " ");
			System.out.println(max);
		}
	}
}