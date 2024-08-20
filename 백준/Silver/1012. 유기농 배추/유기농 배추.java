import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int M, N, K;
	static Point arr[];
	static int map[][];
	static boolean visited[][];
	static int answer;
	static int di[] = { -1, 1, 0, 0 };
	static int dj[] = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			answer = 0;

			map = new int[N][M];
			visited = new boolean[N][M];
			arr = new Point[K];

			for (int i = 0; i < K; i++) {
				int inputJ = sc.nextInt();
				int inputI = sc.nextInt();

				arr[i] = new Point(inputI, inputJ);
				map[inputI][inputJ] = 1;
			}

			for (int idx = 0; idx < K; idx++) {
				int nowI = arr[idx].i;
				int nowJ = arr[idx].j;

				if (!visited[nowI][nowJ]) {
					answer++;
					bfs(idx);
				}
			}

			System.out.println(answer);
		}
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static void bfs(int idx) {
		int nowI = arr[idx].i;
		int nowJ = arr[idx].j;
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(arr[idx]);
		visited[nowI][nowJ] = true;

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nextI = now.i + di[d];
				int nextJ = now.j + dj[d];

				if (nextI >= 0 && nextI < N && nextJ >= 0 && nextJ < M && map[nextI][nextJ] == 1
						&& !visited[nextI][nextJ]) {
					visited[nextI][nextJ] = true;
					queue.add(new Point(nextI, nextJ));
				}
			}
		}
	}
}