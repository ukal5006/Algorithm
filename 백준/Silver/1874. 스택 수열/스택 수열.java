import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		int now = 1;

		for (int i = 0; i < n; i++) {
			int input = sc.nextInt();

			while (true) {
				if (now > input) {
					break;
				} else {
					stack.add(now);
					now++;
					sb.append('+').append('\n');
				}
			}

			if (stack.pop() != input) {
				System.out.println("NO");
				return;
			} else {
				sb.append('-').append('\n');
			}

		}
			System.out.println(sb);
	}
}