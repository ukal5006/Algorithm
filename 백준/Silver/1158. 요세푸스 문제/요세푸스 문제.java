import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}

		System.out.print("<");
		while (true) {
			Queue<Integer> temp = new ArrayDeque<>();
			for (int i = 0; i < K - 1; i++) {
				if (queue.isEmpty()) {
					queue.addAll(temp);
					temp.clear();
				}
				temp.offer(queue.poll());
			}
			if (queue.isEmpty()) {
				queue.addAll(temp);
				temp.clear();
			}
			System.out.print(queue.poll());
			queue.addAll(temp);
			if (queue.isEmpty())
				break;
			System.out.print(", ");
		}
		System.out.print(">");
	}
}