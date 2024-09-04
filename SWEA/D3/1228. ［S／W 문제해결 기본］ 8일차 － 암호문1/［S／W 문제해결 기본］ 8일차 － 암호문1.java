import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int length = sc.nextInt();
			Queue<Integer> queue = new ArrayDeque<>();
			for (int i = 0; i < length; i++) {
				queue.offer(sc.nextInt());
			}

			int count = sc.nextInt();
			for (int i = 0; i < count; i++) {
				String str = sc.next();
				int inputIdx = sc.nextInt();
				int inputLength = sc.nextInt();
				Queue<Integer> temp = new ArrayDeque<>();

				for (int j = 0; j < inputIdx; j++) {
					temp.offer(queue.poll());
				}

				for (int j = 0; j < inputLength; j++) {
					temp.offer(sc.nextInt());
				}

				while (!queue.isEmpty()) {
					temp.offer(queue.poll());
				}

				queue = temp;
			}
			System.out.print("#" + test_case);
			for (int i = 0; i < 10; i++) {
				System.out.print(" " + queue.poll());
			}
			System.out.println();
		}
	}
}