import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean visited[];
	static int N, M;
	static int map[][];
	static int totalCount = Integer.MAX_VALUE;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			map[A][B] = 1;
			map[B][A] = 1;
		}

		for (int i = 1; i <= N; i++) {
			bfs(i);
		}

		System.out.println(answer);
	}

	static void bfs(int idx) {
		visited = new boolean[N + 1];
		visited[idx] = true;
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(idx);
		int count = 0;
		int length = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int now = queue.poll();
				for (int j = 1; j <= N; j++) {
					if (map[now][j] == 1 && !visited[j]) {
						queue.add(j);
						visited[j] = true;
						count += length;
					}
				}
			}
			length++;
		}
		if (count < totalCount) {
			totalCount = count;
			answer = idx;
		}
	}
}