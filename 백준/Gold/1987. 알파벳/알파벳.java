import java.util.Scanner;

public class Main {
	static int R;
	static int C;
	static boolean visited[];
	static int map[][];
	static int max = 0;
	static int di[] = { 1, -1, 0, 0 }; // 상 하 좌 우
	static int dj[] = { 0, 0, -1, 1 }; // 상 하 좌 우

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		visited = new boolean[26];
		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j) - 'A';
			}
		}
		visited[map[0][0]] = true;
		func(0, 0, 1);
		System.out.println(max);
	}

	static void func(int i, int j, int sum) {
		int check = 0;
		for (int d = 0; d < 4; d++) {
			int nextI = i + di[d];
			int nextJ = j + dj[d];

			if (nextI >= 0 && nextI < R && nextJ >= 0 && nextJ < C && !visited[(map[nextI][nextJ])]) {
				check++;
				visited[(map[nextI][nextJ])] = true;
				func(nextI, nextJ, sum + 1);
				visited[(map[nextI][nextJ])] = false;

			}
		}
		if (check == 0) {
			max = Math.max(max, sum);
			return;
		}
	}
}