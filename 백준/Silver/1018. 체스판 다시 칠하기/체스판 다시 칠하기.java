import java.util.Scanner;

public class Main {
	static char arr1[][] = new char[8][8];
	static char arr2[][] = new char[8][8];
	static char map[][];
	static int min = 64;

	public static void main(String[] args) {
		int idx = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (idx % 2 == 0) {
					arr1[i][j] = 'W';
					arr2[i][j] = 'B';
				} else {
					arr1[i][j] = 'B';
					arr2[i][j] = 'W';
				}
				idx++;
			}
			idx++;
		}
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String input = scanner.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				func(i, j);
			}
		}

		System.out.println(min);
	}

	static void func(int i, int j) {
		int arr1Count = 0;
		int arr2Count = 0;
		for (int a = i; a < i + 8; a++) {
			for (int b = j; b < j + 8; b++) {
				if (arr1[a - i][b - j] != map[a][b]) {
					arr1Count += 1;
				}
				if (arr2[a - i][b - j] != map[a][b]) {
					arr2Count += 1;
				}
			}
		}
		min = Math.min(min, arr1Count);
		min = Math.min(min, arr2Count);
	}
}