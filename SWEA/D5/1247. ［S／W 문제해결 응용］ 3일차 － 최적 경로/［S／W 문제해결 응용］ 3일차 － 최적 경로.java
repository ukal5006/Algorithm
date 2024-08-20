import java.util.Scanner;

public class Solution {
	static boolean visited[];
	static int N;
	static int min;
	static Point office;
	static Point home;
	static Point[] points;
	static Point[] visitPoints;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			min = Integer.MAX_VALUE - 1;
			visited = new boolean[N];
			office = new Point(sc.nextInt(), sc.nextInt());
			home = new Point(sc.nextInt(), sc.nextInt());
			points = new Point[N];
			visitPoints = new Point[N + 1];
			visitPoints[0] = office;

			for (int i = 0; i < N; i++) {
				points[i] = new Point(sc.nextInt(), sc.nextInt());
			}

			func(0, 0);
			System.out.print("#" + test_case + " ");
			System.out.println(min);

		}
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static void func(int idx, int sum) {
		if (idx == N) {
			int len = Math.abs(visitPoints[idx].i - home.i) + Math.abs(visitPoints[idx].j - home.j);
			sum += len;
			min = Math.min(sum, min);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				visitPoints[idx + 1] = points[i];
				int len = Math.abs(visitPoints[idx].i - points[i].i) + Math.abs(visitPoints[idx].j - points[i].j);
				func(idx + 1, sum + len);
				visited[i] = false;
			}
		}
	}
}