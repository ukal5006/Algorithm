import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean visited[] = new boolean[100001];

		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(N);
		visited[N] = true;
		int time = 0;
		while (!queue.isEmpty()) {
			int count = queue.size();

			for (int i = 0; i < count; i++) {
				int now = queue.poll();
				if (now == K) {
					System.out.println(time);
					return;
				}

				if (now - 1 >= 0 && !visited[now - 1]) {
					visited[now - 1] = true;
					queue.add(now - 1);
				}
				if (now + 1 < 100001 && !visited[now + 1]) {
					visited[now + 1] = true;
					queue.add(now + 1);
				}
				if (now * 2 < 100001 && !visited[now * 2]) {
					visited[now * 2] = true;
					queue.add(now * 2);
				}
			}

			time++;
		}

	}
}