import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int map[][];
	static int copyMap[][];
	static boolean visited[][];
	static int cheezeCount = 0;
	static int time = 0;
	static int totalCheeze = 0;
	static int I;
	static int J;
	static int di[] = { -1, 1, 0, 0 };
	static int dj[] = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		I = scanner.nextInt();
		J = scanner.nextInt();
		map = new int[I][J];
		copyMap = new int[I][J];
		visited = new boolean[I][J];

		for (int i = 0; i < I; i++) {
			for (int j = 0; j < J; j++) {
				map[i][j] = scanner.nextInt();
				if (map[i][j] == 1) {
					totalCheeze += 1;
				}

			}
		}

		while (totalCheeze != 0) {
			func(0, 0);
			time += 1;
		}

		System.out.println(time);
		System.out.println(cheezeCount);

	}

	static void func(int i, int j) {
		cheezeCount = 0;
		Queue<Point> queue = new ArrayDeque<Point>();
		queue.offer(new Point(i, j));
		visited[i][j] = true;
		trans(copyMap, map);
		while (!queue.isEmpty()) {
			Point nowPoint = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nextI = nowPoint.i + di[d];
				int nextJ = nowPoint.j + dj[d];

				if (nextI >= 0 && nextI < I && nextJ >= 0 && nextJ < J && !visited[nextI][nextJ]) {
					if (copyMap[nextI][nextJ] == 0) {
						visited[nextI][nextJ] = true;
						queue.offer(new Point(nextI, nextJ));
					} else if (copyMap[nextI][nextJ] == 1) {
						copyMap[nextI][nextJ] = 2;
						cheezeCount += 1;
						totalCheeze -= 1;
					}
				}
			}

		}
		trans(map, copyMap);
		visited = new boolean[I][J];
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static void trans(int target[][], int base[][]) {
		for (int i = 0; i < I; i++) {
			for (int j = 0; j < J; j++) {
				if (base[i][j] == 2) {
					target[i][j] = 0;
				} else {
					target[i][j] = base[i][j];
				}
			}
		}
	}
}