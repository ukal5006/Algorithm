import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int adj[][];
	static boolean visited[];
	static int N;
	static int answer = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int R = sc.nextInt();
		adj = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < R; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj[a][b] = 1;
			adj[b][a] = 1;
		}

		check(1);
		System.out.println(answer);

	}

	static void check(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int temp = queue.poll();

			for (int i = 1; i <= N; i++) {
				if (adj[temp][i] == 1 && !visited[i]) {
					answer++;
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
	}
}